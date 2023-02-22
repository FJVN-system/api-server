package com.api.apiserver.service;


import com.api.apiserver.DTO.cartsitem.CartsItemDTO;
import com.api.apiserver.DTO.ordersitem.OrderDTO;
import com.api.apiserver.DTO.ordersitem.OrdersItemDTO;

import java.util.List;

public interface OrdersItemService {
    List<OrdersItemDTO> getAllOrdersItems();

    List<OrdersItemDTO> getAllOrdersItemsByUserIdAndCompanyId(Long companyId, Long userId);

    OrderDTO createOrderItem(Long userId);
}
