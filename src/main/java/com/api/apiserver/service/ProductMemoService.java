package com.api.apiserver.service;

import com.api.apiserver.DTO.ProductMemo.ProductMemoDto;
import com.api.apiserver.domain.ProductMemo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public interface ProductMemoService {

    List<ProductMemoDto> getProductMemoByProductId(Long productId);


}
