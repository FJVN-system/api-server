package com.api.apiserver.service;

import com.api.apiserver.DTO.cartsitem.CartsItemDTO;
import com.api.apiserver.DTO.ordersitem.OrderDTO;
import com.api.apiserver.DTO.ordersitem.OrdersItemDTO;
import com.api.apiserver.domain.CartsItem;
import com.api.apiserver.domain.OrdersItem;
import com.api.apiserver.repository.CartsItemRepository;
import com.api.apiserver.repository.OrdersItemRepository;
import com.api.apiserver.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor
public class OrdersItemServiceImpl implements OrdersItemService{

    private final OrdersItemRepository ordersItemRepository;
    private final CartsItemRepository cartsItemRepository;
    private final UsersService usersService;
    private final CartsItemService cartsItemService;
    @Override
    public List<OrdersItemDTO> getAllOrdersItems() {
        List<OrdersItem> ordersItemList = ordersItemRepository.findAll();
        return ordersItemList
                .stream()
                .map(OrdersItemDTO::fromEntity)
                .toList();
    }

    @Override
    public List<OrdersItemDTO> getAllOrdersItemsByUserIdAndCompanyId(Long companyId, Long userId) {
        List<OrdersItem> ordersItemList = ordersItemRepository.findByCompany_IdAndUsers_Id(companyId, userId);
        return ordersItemList
                .stream()
                .map(OrdersItemDTO::fromEntity)
                .toList();
    }

    @Override
    public OrderDTO createOrderItem(Long userId) {
        usersService.getUser(userId);
        List<CartsItem> cartsItems = cartsItemRepository.findAllByUsers_Id(userId);
        OrderDTO orderDTO = new OrderDTO(0L,0L,0L);
        for (CartsItem cartsItem : cartsItems) {
            ordersItemRepository.save(OrdersItem.builder()
                    .product(cartsItem.getProduct())
                    .users(cartsItem.getUsers())
                    .company(cartsItem.getUsers().getCompany())
                    .price(cartsItem.getPrice())
                    .qty(cartsItem.getQty())
                    .shipped(false)
                    .createdAt(cartsItem.getCreatedAt())
                    .updatedAt(LocalDateTime.now())
                    .build());
            cartsItemService.deleteCartsItem(userId, cartsItem.getId());
            orderDTO.setItemCount(orderDTO.getItemCount() + 1);
            orderDTO.setItemQty(orderDTO.getItemQty() + cartsItem.getQty());
            orderDTO.setTotalPrice(orderDTO.getTotalPrice() + cartsItem.getPrice());
        }
        return orderDTO;
    }
}
