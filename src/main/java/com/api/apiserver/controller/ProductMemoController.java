
package com.api.apiserver.controller;

import com.api.apiserver.DTO.ProductMemo.ProductMemoDto;
import com.api.apiserver.DTO.ProductMemo.ProductMemoPatchDto;
import com.api.apiserver.DTO.ProductMemo.ProductMemoPostDto;
import com.api.apiserver.domain.ProductMemo;
import com.api.apiserver.service.ProductMemoService;
import com.api.apiserver.service.ProductMemoServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Negative;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@AllArgsConstructor
public class ProductMemoController {

    private final ProductMemoService productMemoService;
    private final ProductMemoServiceImpl productMemoServiceImpl;

    // TODO 테스트코드 작성필요
    @GetMapping("/productmemo/{productId}")
    public ResponseEntity<List<ProductMemoDto>> getProductMemoByProductId(
            @Valid @PathVariable("productId") Long productId) {
        return ResponseEntity.ok(productMemoService.
                getProductMemoByProductId(productId));
    }


    @PostMapping("/productmemo")
    public ResponseEntity<Long> createProductMemo(
            @Valid @RequestBody ProductMemoPostDto productMemoPostDto) {

        ProductMemo productMemo = productMemoService.setProductMemo(productMemoPostDto);
        return ResponseEntity.ok(productMemo.getProductMemoId());
    }


    @DeleteMapping("/productmemo/{productMemoId}")
    public ResponseEntity<String> deleteProductMemo(
           @Valid @PathVariable("productMemoId") Long productMemoId) {
        productMemoService.deleteProductMemo(productMemoId);

        return ResponseEntity.ok("삭제성공");
    }

//    @PatchMapping("/productmemo/{productId}")
//    public ResponseEntity<Long> patchProductMemo(
//            @PathVariable("productId")
//            @Valid @RequestBody ProductMemoPatchDto productMemoPatchDto) {
//
//        productMemoPatchDto.setProductMemoId(productMemoPatchDto.getProductMemoId());
//
//        productMemoService.updateProductMemo(productMemoPatchDto);
//
//        return ResponseEntity.ok(productMemoPatchDto.getProductMemoId());
//    }
}





