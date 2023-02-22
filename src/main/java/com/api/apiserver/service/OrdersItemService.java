package com.api.apiserver.service;


import com.api.apiserver.DTO.cartsitem.CartsItemDTO;
import com.api.apiserver.DTO.ordersitem.OrderDTO;
import com.api.apiserver.DTO.ordersitem.OrdersItemDTO;
import com.api.apiserver.domain.CartsItem;
import com.api.apiserver.domain.OrdersItem;

import java.util.List;
import java.util.Optional;

public interface OrdersItemService {
    List<OrdersItemDTO> getAllOrdersItems();

    List<OrdersItemDTO> getAllOrdersItemsByUserIdAndCompanyId(Long companyId, Long userId);

    Optional<OrdersItem> getOrderItemByUserIdAndProductId(Long userId, Long productId);

    OrderDTO createOrderItem(Long userId);
}
