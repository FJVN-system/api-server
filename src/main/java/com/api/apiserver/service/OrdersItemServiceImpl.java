package com.api.apiserver.service;

import com.api.apiserver.DTO.cartsitem.CartsItemDTO;
import com.api.apiserver.DTO.ordersitem.OrdersItemDTO;
import com.api.apiserver.domain.CartsItem;
import com.api.apiserver.domain.OrdersItem;
import com.api.apiserver.repository.CartsItemRepository;
import com.api.apiserver.repository.OrdersItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor
public class OrdersItemServiceImpl implements OrdersItemService{

    private final OrdersItemRepository ordersItemRepository;
    @Override
    public List<OrdersItemDTO> getAllOrdersItems() {
        List<OrdersItem> ordersItemList = ordersItemRepository.findAll();
        return ordersItemList
                .stream()
                .map(OrdersItemDTO::fromEntity)
                .toList();
    }

    @Override
    public List<OrdersItemDTO> getAllOrdersItemsByUserId(Long userId) {
        List<OrdersItem> ordersItemList = ordersItemRepository.findByUsers_Id(userId);
        return ordersItemList
                .stream()
                .map(OrdersItemDTO::fromEntity)
                .toList();
    }
}
