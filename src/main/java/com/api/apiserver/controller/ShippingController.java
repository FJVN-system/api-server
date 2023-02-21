package com.api.apiserver.controller;

import com.api.apiserver.DTO.product.ProductsDTO;
import com.api.apiserver.DTO.shipping.ShippingDTO;
import com.api.apiserver.service.ProductService;
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
public class ShippingController {

    private final ShippingService shippingService;

    @GetMapping("/{companyId}/shipping/{userId}")
    public ResponseEntity<List<ShippingDTO>> getAllShippingByCompanyIdAndUsersId(
            @Valid @PathVariable("companyId") Long companyId,
            @Valid @PathVariable("userId") Long userId) {
        return ResponseEntity.ok(shippingService.getAllProductsByCompanyIdAndUsersId(companyId, userId));
    }

}
