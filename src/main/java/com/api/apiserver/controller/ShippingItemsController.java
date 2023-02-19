package com.api.apiserver.controller;

import com.api.apiserver.DTO.shipping.ShippingDTO;
import com.api.apiserver.DTO.shippingitem.ShippingItemDTO;
import com.api.apiserver.service.ShippingItemsService;
import com.api.apiserver.service.ShippingService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;


@RestController
@AllArgsConstructor
public class ShippingItemsController {

    private final ShippingItemsService shippingItemsService;

    @GetMapping("/shippingitems/{shippingId}")
    public ResponseEntity<List<ShippingItemDTO>> getAllShippingItemsByShippingId(
            @Valid @PathVariable("shippingId") Long shippingId) {
        return ResponseEntity.ok(shippingItemsService.getAllShippingItemsByShippingId(shippingId));
    }

}
