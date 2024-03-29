package com.api.apiserver.service;

import com.api.apiserver.DTO.cartsitem.CartsItemDTO;
import com.api.apiserver.DTO.ordersitem.OrderDTO;
import com.api.apiserver.DTO.ordersitem.OrdersItemDTO;
import com.api.apiserver.domain.CartsItem;
import com.api.apiserver.domain.OrdersItem;
import com.api.apiserver.domain.Product;
import com.api.apiserver.exception.CartsItemException;
import com.api.apiserver.repository.CartsItemRepository;
import com.api.apiserver.repository.OrdersItemRepository;
import com.api.apiserver.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static com.api.apiserver.type.ErrorCode.CART_ITEMS_NOT_FOUND;
import static com.api.apiserver.type.ErrorCode.ORDER_QTY_EXCEED_STOCK;

@Transactional
@Service
@RequiredArgsConstructor
public class OrdersItemServiceImpl implements OrdersItemService{

    private final OrdersItemRepository ordersItemRepository;
    private final UsersService usersService;
    private final CartsItemService cartsItemService;

    // TODO 테스트코드 작성필요
    @Override
    public List<OrdersItemDTO> getAllOrdersItems() {
        List<OrdersItem> ordersItemList = ordersItemRepository.findAll();
        return ordersItemList
                .stream()
                .map(OrdersItemDTO::fromEntity)
                .toList();
    }

    // TODO 테스트코드 작성필요
    @Override
    public List<OrdersItemDTO> getAllOrdersItemsByUserIdAndCompanyId(Long companyId, Long userId) {
        List<OrdersItem> ordersItemList = ordersItemRepository.findByCompany_IdAndUsers_Id(companyId, userId);
        return ordersItemList
                .stream()
                .map(OrdersItemDTO::fromEntity)
                .toList();
    }

    // TODO 테스트코드 작성필요
    @Override
    public List<OrdersItemDTO> getAllOrdersItemsByCompanyId(Long companyId) {
        List<OrdersItem> ordersItems = ordersItemRepository.findByCompany_Id(companyId);
        return ordersItems
                .stream()
                .map(OrdersItemDTO::fromEntity)
                .toList();
    }

    // TODO 테스트코드 작성필요
    @Override
    public Optional<OrdersItem> getOrderItemByUserIdAndProductId(Long userId, Long productId) {
        return ordersItemRepository.findByUsers_IdAndProduct_Id(userId, productId);
    }

    // TODO 테스트코드 작성필요
    @Transactional
    @Override
    public OrderDTO createOrderItem(Long userId) {
        usersService.getUser(userId);
        List<CartsItem> cartsItems = cartsItemService.getAllByUsers_Id(userId);

        validateCartsItems(cartsItems);

        OrderDTO orderDTO = new OrderDTO(0L,0L,0L);
        for (CartsItem cartsItem : cartsItems) {
//            카트아이템에서 상품아이디 찾아서
            Long productId = cartsItem.getProduct().getId();

//            유저아이디 + 상품아이디로 주문이 있나 확인
            Optional<OrdersItem> ordersItem = getOrderItemByUserIdAndProductId(userId, productId);

            if (ordersItem.isPresent()) {
                //            있으면 기존 주문에 수량을 더해서 재고랑 비교후 재고보다 크면 익샙션,
                validateProductQty(cartsItem.getProduct(), ordersItem.get().getQty() + cartsItem.getQty());
                ordersItemRepository.save(OrdersItem.builder()
                        .id(ordersItem.get().getId())
                        .product(cartsItem.getProduct())
                        .users(cartsItem.getUsers())
                        .company(cartsItem.getUsers().getCompany())
                        .price(cartsItem.getPrice())
                        .qty(cartsItem.getQty() + ordersItem.get().getQty())
                        .shipped(false)
                        .deleted(false)
                        .picked(false)
                        .canceled(false)
                        .createdAt(cartsItem.getCreatedAt())
                        .updatedAt(LocalDateTime.now())
                        .build());
            }else {
//            없으면 상품의 재고랑 비교 후 저장
                validateProductQty(cartsItem.getProduct(), cartsItem.getQty());
                ordersItemRepository.save(OrdersItem.builder()
                        .product(cartsItem.getProduct())
                        .users(cartsItem.getUsers())
                        .company(cartsItem.getUsers().getCompany())
                        .price(cartsItem.getPrice())
                        .qty(cartsItem.getQty())
                        .shipped(false)
                        .deleted(false)
                        .picked(false)
                        .canceled(false)
                        .createdAt(cartsItem.getCreatedAt())
                        .updatedAt(LocalDateTime.now())
                        .build());
            }
            cartsItemService.deleteCartsItem(userId, cartsItem.getId());
            // TODO 주문시 상품 수량 감소
            orderDTO.setItemCount(orderDTO.getItemCount() + 1);
            orderDTO.setItemQty(orderDTO.getItemQty() + cartsItem.getQty());
            orderDTO.setTotalPrice(orderDTO.getTotalPrice() + cartsItem.getPrice());
        }
        return orderDTO;
    }

    // TODO 테스트코드 작성필요
    private void validateCartsItems(List<CartsItem> cartsItems) {
        if (cartsItems.size() == 0) {
            throw new CartsItemException(CART_ITEMS_NOT_FOUND);
        }
    }

    // TODO 테스트코드 작성필요
    private void validateProductQty(Product product, Long qty) throws CartsItemException {
        if (product.getStock() < qty) {
            throw new CartsItemException(ORDER_QTY_EXCEED_STOCK, product.getStock());
        }
    }
}
