package com.api.apiserver.service;

import com.api.apiserver.domain.ProductMemo;
import com.api.apiserver.repository.ProductMemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductMemoServiceImpl implements ProductMemoService{

    private final ProductMemoRepository productMemoRepository;

    @Override
    public List<ProductMemo> getProductMemoByProductId(Long productId) {
        List<ProductMemo> productMemos = productMemoRepository.findAllByProduct_Id(productId);
        /*
        1.
         */

        return productMemos;
    }
}
