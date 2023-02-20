package com.api.apiserver.controller;

import com.api.apiserver.DTO.cartsitem.CartsItemDTO;
import com.api.apiserver.service.CartsItemService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
public class HealthController {

    @GetMapping("/healthcheck")
    public ResponseEntity<String> healthcheck() {
        return ResponseEntity.ok("ok");
    }

//    private final CartsItemService cartsItemService;

//    @GetMapping("/healthcheck")
//    public ResponseEntity<List<CartsItemDTO>> getAllCartsItems() {
//        return ResponseEntity.ok(cartsItemService.getAllCartsItems());
//    }

//    @GetMapping("/carts/{userId}")
//    public ResponseEntity<List<CartsItemDTO>> getAllCartsItemsByUserId(
//            @Valid @PathVariable("userId") Long userId
//    ) {
//        return ResponseEntity.ok(cartsItemService.getAllCartsItemsByUserId(userId));
//    }

}
