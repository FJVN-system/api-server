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
import java.util.Optional;

import static com.api.apiserver.type.ErrorCode.*;

@Transactional
@Service
@RequiredArgsConstructor
public class CartsItemServiceImpl implements CartsItemService{

    private final CartsItemRepository cartsItemRepository;
    private final UsersService usersService;
    private final ProductService productService;

    @Override
    public CartsItem getCartsItem(Long cartItemId) {
        return cartsItemRepository.findById(cartItemId)
                .orElseThrow(() -> new CartsItemException(CART_ITEM_NOT_FOUND));

    }

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
    public List<CartsItemDTO> getAllCartsItemsByUserIdAndProductId(Long userId, Long productId) {
        List<CartsItem> cartsItemList = cartsItemRepository.findByUsers_IdAndProduct_Id(userId, productId);
        return cartsItemList
                .stream()
                .map(CartsItemDTO::fromEntity)
                .toList();
    }

    @Override
    public CartsItemDTO createCartsItem(Long userId, Long productId, Long qty) {
        Users user = usersService.getUser(userId);
        Product product = productService.getProduct(productId);

        validateAlreadyExistCartsItem(user, product);
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

    @Override
    public CartsItemDTO deleteCartsItem(Long userId, Long cartItemId) {
        usersService.getUser(userId);
//        TODO 응답값 수정이랑 벨리데이션, 익셉션 추가해야함
        Optional<CartsItem> cartsItem = cartsItemRepository.findById(cartItemId);
        if (cartsItem.isPresent()) {
            cartsItemRepository.deleteById(cartsItem.get().getId());
            return CartsItemDTO.fromEntity(cartsItem.get());
        }
        return null;
    }


    @Override
    public CartsItemDTO modifyCartsItem(Long usersId, Long cartItemId, Long qty) {
        Users user = usersService.getUser(usersId);
        CartsItem cartsItem = getCartsItem(cartItemId);
        validateModifyCartsItem(cartsItem.getProduct(), qty);
        return CartsItemDTO.fromEntity(cartsItemRepository.save(
                CartsItem.builder()
                        .id(cartItemId)
                        .product(cartsItem.getProduct())
                        .price(cartsItem.getProduct().getPrice() * qty)
                        .users(user)
                        .qty(qty)
                        .createdAt(cartsItem.getCreatedAt())
                        .updatedAt(LocalDateTime.now())
                        .build()));
    }

    private void validateCreateCartsItem(Product product, Long qty) throws CartsItemException {
        if (product.getStock() <= qty) {
            throw new CartsItemException(ORDER_QTY_EXCEED_STOCK);
        }
    }

    private void validateModifyCartsItem(Product product, Long qty) throws CartsItemException {
        if (product.getStock() <= qty) {
            throw new CartsItemException(ORDER_QTY_EXCEED_STOCK);
        }
    }

    private void validateAlreadyExistCartsItem(Users users, Product product) throws CartsItemException {
        List<CartsItemDTO> cartsItemDTO = getAllCartsItemsByUserIdAndProductId(users.getId(), product.getId());
        if (cartsItemDTO.size() > 0) {
            throw new CartsItemException(ALREADY_ADDED_ON_CART);
        }
    }




}
