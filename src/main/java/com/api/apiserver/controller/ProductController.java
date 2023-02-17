package com.api.apiserver.controller;

import com.api.apiserver.DTO.product.ProductsDTO;
import com.api.apiserver.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;


@RestController
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<ProductsDTO>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/products/{companyId}")
    public ResponseEntity<List<ProductsDTO>> getAllProductsByCompanyId(
            @Valid @PathVariable("companyId") String companyId
    ) {
        return ResponseEntity.ok(productService.getAllProductsByCompanyId(companyId));
    }

    @GetMapping("/products/{companyId}/{category}")
    public ResponseEntity<List<ProductsDTO>> getAllProductsByCompanyIdAndCategory(
            @Valid @PathVariable("companyId") String companyId,
            @Valid @PathVariable("category") String category) {
        return ResponseEntity.ok(productService.getAllProductsByCompanyIdAndCategory(companyId, category));
    }

}
