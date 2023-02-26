package com.api.apiserver.service;

import com.api.apiserver.DTO.ProductMemo.ProductMemoDto;
import com.api.apiserver.domain.ProductMemo;
import com.api.apiserver.repository.ProductMemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductMemoServiceImpl implements ProductMemoService{

    private final ProductMemoRepository productMemoRepository;

    @Override
    public List<ProductMemoDto> getProductMemoByProductId(Long productId) {
        List<ProductMemo> productMemos = productMemoRepository.findAllByProduct_Id(productId);

        List<ProductMemoDto> productMemoDtoStream = productMemos.stream()
                .map(productMemo ->
                        new ProductMemoDto(
                                productMemo.getProductMemoId(),
                                productMemo.getMemoTime(),
                                productMemo.getMemoUser(),
                                productMemo.getMemoCorrectionTime()))
                .collect(Collectors.toList());


        System.out.println(productMemos.get(0).getProduct().getTitle());


        return productMemoDtoStream;
    }
}
