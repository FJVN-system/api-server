package com.api.apiserver.controller;

import com.api.apiserver.DTO.product.CreateProduct;
import com.api.apiserver.DTO.product.CreateProductBulk;
import com.api.apiserver.DTO.product.ProductsDTO;
import com.api.apiserver.domain.Product;
import com.api.apiserver.service.CompanyService;
import com.api.apiserver.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    // TODO 테스트코드 작성필요
    @GetMapping("/products")
    public ResponseEntity<List<ProductsDTO>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    // TODO 테스트코드 작성필요
    @GetMapping("/{companyId}/products")
    public ResponseEntity<List<ProductsDTO>> getAllProductsByCompanyId(
            @Valid @PathVariable("companyId") Long companyId
    ) {
        return ResponseEntity.ok(productService.getAllProductsByCompanyId(companyId));
    }

    // TODO 테스트코드 작성필요
    @GetMapping("/{companyId}/products/{category}")
    public ResponseEntity<List<ProductsDTO>> getAllProductsByCompanyIdAndCategory(
            @Valid @PathVariable("companyId") Long companyId,
            @Valid @PathVariable("category") String category) {
        return ResponseEntity.ok(productService.getAllProductsByCompanyIdAndCategory(companyId, category));
    }

    // TODO 테스트코드 작성필요
    @PostMapping("/{companyId}/products")
    public ResponseEntity<Product> createProduct(
            @Valid @PathVariable("companyId") Long companyId,
            @RequestBody @Valid CreateProduct.Request request
    ) {

        return ResponseEntity.ok(productService.createProduct(request, companyId));
    }

    // TODO 테스트코드 작성필요
    @PostMapping("/{companyId}/products/bulk")
    public int createProductsBulk(
            @Valid @PathVariable("companyId") Long companyId,
            @RequestBody @Valid List<CreateProductBulk.Request> request
    ) {
        List<Product> productList = productService.createProductsBulk(request, companyId);

        return productList.size();
    }

}
