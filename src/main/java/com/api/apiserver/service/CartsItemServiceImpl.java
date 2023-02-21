package com.api.apiserver.service;

import com.api.apiserver.DTO.cartsitem.CartsItemDTO;
import com.api.apiserver.domain.CartsItem;
import com.api.apiserver.domain.Product;
import com.api.apiserver.domain.Users;
import com.api.apiserver.exception.CartsItemException;
import com.api.apiserver.repository.CartsItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static com.api.apiserver.type.ErrorCode.*;

@Transactional
@Service
@RequiredArgsConstructor
public class CartsItemServiceImpl implements CartsItemService{

    private final CartsItemRepository cartsItemRepository;
    private final UsersService usersService;
    private final ProductService productService;

    @Override
    public List<CartsItemDTO> getAllCartsItems() {
        List<CartsItem> cartsItemList = cartsItemRepository.findAll();
        return cartsItemList
                .stream()
                .map(CartsItemDTO::fromEntity)
                .toList();
    }

    @Override
    public List<CartsItemDTO> getAllCartsItemsByUserId(Long userId) {
        List<CartsItem> cartsItemList = cartsItemRepository.findByUsers_Id(userId);
        return cartsItemList
                .stream()
                .map(CartsItemDTO::fromEntity)
                .toList();
    }

    @Override
    public CartsItemDTO createCartsItem(Long userId, Long productId, Long qty) {
        Users user = usersService.getUser(userId);
        Product product = productService.getProduct(productId);

        validateAlreadyExistCartsItem(user);
        validateCreateCartsItem(product, qty);

        return CartsItemDTO.fromEntity(cartsItemRepository.save(
                CartsItem.builder()
                        .product(product)
                        .price(product.getPrice() * qty)
                        .users(user)
                        .qty(qty)
                        .createdAt(LocalDateTime.now())
                        .updatedAt(LocalDateTime.now())
                        .build()));
    }

    private void validateCreateCartsItem(Product product, Long qty) throws CartsItemException {
        if (product.getStock() <= qty) {
            throw new CartsItemException(ORDER_QTY_EXCEED_STOCK);
        }
    }

    private void validateAlreadyExistCartsItem(Users users) throws CartsItemException {
        List<CartsItemDTO> cartsItemDTO = getAllCartsItemsByUserId(users.getId());
        if (cartsItemDTO.size() > 0) {
            throw new CartsItemException(ALREADY_ADDED_ON_CART);
        }
    }




}
