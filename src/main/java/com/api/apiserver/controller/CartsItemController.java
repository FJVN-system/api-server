package com.api.apiserver.controller;

import com.api.apiserver.DTO.cartsitem.CartsItemDTO;
import com.api.apiserver.DTO.users.CreateUsers;
import com.api.apiserver.DTO.users.UsersDTO;
import com.api.apiserver.service.CartsItemService;
import com.api.apiserver.service.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
public class CartsItemController {

    private final CartsItemService cartsItemService;

    @GetMapping("/carts")
    public ResponseEntity<List<CartsItemDTO>> getAllCartsItems() {
        return ResponseEntity.ok(cartsItemService.getAllCartsItems());
    }

    @GetMapping("/carts/{userId}")
    public ResponseEntity<List<CartsItemDTO>> getAllCartsItemsByUserId(
            @Valid @PathVariable("userId") Long userId
    ) {
        return ResponseEntity.ok(cartsItemService.getAllCartsItemsByUserId(userId));
    }

}
