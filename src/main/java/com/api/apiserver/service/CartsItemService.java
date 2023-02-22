package com.api.apiserver.service;


import com.api.apiserver.DTO.cartsitem.CartsItemDTO;
import com.api.apiserver.domain.CartsItem;

import java.util.List;

public interface CartsItemService {
    List<CartsItemDTO> getAllCartsItems();

    List<CartsItemDTO> getAllCartsItemsByUserId(Long userId);
    List<CartsItemDTO> getAllCartsItemsByUserIdAndProductId(Long userId, Long productId);

    CartsItem getCartsItem(Long cartItemId);

    CartsItemDTO createCartsItem(Long userId, Long productId, Long qty);
    CartsItemDTO deleteCartsItem(Long userId, Long cartItemId);

    CartsItemDTO modifyCartsItem(Long usersId, Long cartItemId, Long qty);
}
