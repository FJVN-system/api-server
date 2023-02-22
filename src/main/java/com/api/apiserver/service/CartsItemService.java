package com.api.apiserver.service;


import com.api.apiserver.DTO.cartsitem.CartsItemDTO;

import java.util.List;

public interface CartsItemService {
    List<CartsItemDTO> getAllCartsItems();

    List<CartsItemDTO> getAllCartsItemsByUserId(Long userId);
    List<CartsItemDTO> getAllCartsItemsByUserIdAndProductId(Long userId, Long productId);

    CartsItemDTO createCartsItem(Long userId, Long productId, Long qty);
    String deleteCartsItem(Long userId, Long cartItemId);
}
