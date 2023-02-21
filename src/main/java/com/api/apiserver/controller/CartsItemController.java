package com.api.apiserver.controller;

import com.api.apiserver.DTO.cartsitem.CartsItemDTO;
import com.api.apiserver.DTO.cartsitem.CreateCartsItem;
import com.api.apiserver.DTO.users.CreateUsers;
import com.api.apiserver.service.CartsItemService;
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

    @PostMapping("/carts")
    public ResponseEntity<CreateCartsItem.Response>  createUser(
            @RequestBody @Valid CreateCartsItem.Request request
    ) {

        return ResponseEntity.ok(CreateCartsItem.Response.from(
                cartsItemService.createCartsItem(
                        request.getUsersId(),
                        request.getProductId(),
                        request.getQty()
                )));
    }

    @GetMapping("/carts/{userId}")
    public ResponseEntity<List<CartsItemDTO>> getAllCartsItemsByUserId(
            @Valid @PathVariable("userId") Long userId
    ) {
        return ResponseEntity.ok(cartsItemService.getAllCartsItemsByUserId(userId));
    }

}
