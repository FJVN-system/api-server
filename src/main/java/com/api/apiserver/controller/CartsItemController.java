package com.api.apiserver.controller;

import com.api.apiserver.DTO.cartsitem.CartsItemDTO;
import com.api.apiserver.DTO.cartsitem.CreateCartsItem;
import com.api.apiserver.DTO.cartsitem.DeleteCartsItem;
import com.api.apiserver.DTO.cartsitem.ModifyCartsItem;
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

    // TODO 테스트코드 작성필요
    @GetMapping("/carts")
    public ResponseEntity<List<CartsItemDTO>> getAllCartsItems() {
        return ResponseEntity.ok(cartsItemService.getAllCartsItems());
    }

    // TODO 테스트코드 작성필요(실패 케이스들: 상품이 없거나, 유저가 없거나 -> 서비스에서 했는데 여기서도 해야하나?)
    @PostMapping("/carts")
    public ResponseEntity<CreateCartsItem.Response>  createCartsItem(
            @RequestBody @Valid CreateCartsItem.Request request
    ) {
        return ResponseEntity.ok(CreateCartsItem.Response.from(
                cartsItemService.createCartsItem(
                        request.getUsersId(),
                        request.getProductId(),
                        request.getQty()
                )));
    }

    // TODO 테스트코드 작성필요
    @PutMapping("/carts")
    public ResponseEntity<ModifyCartsItem.Response>  modifyCartItem(
            @RequestBody @Valid ModifyCartsItem.Request request) {
        return ResponseEntity.ok(ModifyCartsItem.Response.from(
                cartsItemService.modifyCartsItem(
                        request.getUsersId(),
                        request.getCartItemId(),
                        request.getQty())));
    }

    // TODO 테스트코드 작성필요
    @DeleteMapping("/carts")
    public ResponseEntity<DeleteCartsItem.Response>  deleteCartItem(
            @RequestBody @Valid DeleteCartsItem.Request request) {
        return ResponseEntity.ok(DeleteCartsItem.Response.from(
                cartsItemService.deleteCartsItem(
                        request.getUsersId(),
                        request.getCartItemId())));
    }

    @GetMapping("/carts/{userId}")
    public ResponseEntity<List<CartsItemDTO>> getAllCartsItemsByUserId(
            @Valid @PathVariable("userId") Long userId
    ) {
        return ResponseEntity.ok(cartsItemService.getAllCartsItemsByUserId(userId));
    }

}
