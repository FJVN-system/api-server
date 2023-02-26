package com.api.apiserver.controller;

import com.api.apiserver.DTO.ProductMemo.ProductMemoDto;
import com.api.apiserver.domain.ProductMemo;
import com.api.apiserver.service.ProductMemoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
public class ProductMemoController {

    private final ProductMemoService productMemoService;
    // TODO 테스트코드 작성필요
    @GetMapping("/productmemo/{productId}")
    public ResponseEntity<List<ProductMemoDto>> getProductMemoByProductId(
            @Valid @PathVariable("productId") Long productId)
     {

        return ResponseEntity.ok(productMemoService.getProductMemoByProductId(productId));
    }

}
