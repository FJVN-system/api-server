package com.api.apiserver.service;


import com.api.apiserver.DTO.cartsitem.CartsItemDTO;
import com.api.apiserver.DTO.users.UsersDTO;

import java.util.List;

public interface CartsItemService {
    List<CartsItemDTO> getAllCartsItems();

    List<CartsItemDTO> getAllCartsItemsByUserId(Long userId);

    CartsItemDTO createCartsItem(Long userId, Long productId, Long qty);
}
