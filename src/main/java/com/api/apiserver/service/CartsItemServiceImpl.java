package com.api.apiserver.service;

import com.api.apiserver.DTO.cartsitem.CartsItemDTO;
import com.api.apiserver.DTO.users.UsersDTO;
import com.api.apiserver.domain.CartsItem;
import com.api.apiserver.domain.Users;
import com.api.apiserver.repository.CartsItemRepository;
import com.api.apiserver.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor
public class CartsItemServiceImpl implements CartsItemService{

    private final CartsItemRepository cartsItemRepository;
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
}
