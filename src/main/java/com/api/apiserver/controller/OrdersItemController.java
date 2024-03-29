package com.api.apiserver.controller;

import com.api.apiserver.DTO.cartsitem.CartsItemDTO;
import com.api.apiserver.DTO.ordersitem.OrderDTO;
import com.api.apiserver.DTO.ordersitem.OrdersItemDTO;
import com.api.apiserver.service.CartsItemService;
import com.api.apiserver.service.OrdersItemService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
public class OrdersItemController {

    private final OrdersItemService ordersItemService;

    // TODO 테스트코드 작성필요
    @GetMapping("/ordersitem")
    public ResponseEntity<List<OrdersItemDTO>> getAllOrdersItems() {
        return ResponseEntity.ok(ordersItemService.getAllOrdersItems());
    }

    // TODO 테스트코드 작성필요
    @GetMapping("/{companyId}/ordersitem")
    public ResponseEntity<List<OrdersItemDTO>> getAllOrdersItemsByCompanyId(
            @Valid @PathVariable("companyId") Long companyId
    ) {
        return ResponseEntity.ok(ordersItemService.getAllOrdersItemsByCompanyId(companyId));
    }

    // TODO 테스트코드 작성필요
    @PostMapping("/ordersitem/{userId}")
    public ResponseEntity<OrderDTO> createOrder(
            @Valid @PathVariable("userId") Long userId) {
        return ResponseEntity.ok(ordersItemService.createOrderItem(userId));
    }

    // TODO 테스트코드 작성필요
    @GetMapping("/{companyId}/ordersitem/{userId}")
    public ResponseEntity<List<OrdersItemDTO>> getAllCartsItemsByUserIdAndCompanyId(
            @Valid @PathVariable("companyId") Long companyId,
            @Valid @PathVariable("userId") Long userId
    ) {
        return ResponseEntity.ok(ordersItemService.getAllOrdersItemsByUserIdAndCompanyId(companyId, userId));
    }

}
