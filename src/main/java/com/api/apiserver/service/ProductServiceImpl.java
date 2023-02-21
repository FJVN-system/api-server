package com.api.apiserver.service;

import com.api.apiserver.DTO.product.ProductsDTO;
import com.api.apiserver.domain.Product;
import com.api.apiserver.exception.ProductException;
import com.api.apiserver.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.api.apiserver.type.ErrorCode.PRODUCT_NOT_FOUND;

@Transactional
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{


    private final ProductRepository productRepository;

    @Transactional
    public Product getProduct(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new ProductException(PRODUCT_NOT_FOUND));
    }


    @Override
    public List<ProductsDTO> getAllProducts(){
        List<Product> products = productRepository.findAll();
        return products
                .stream()
                .map(ProductsDTO::new)
                .toList();
    }


    @Override
    public List<ProductsDTO> getAllProductsByCompanyId(Long companyId) {
        List<Product> products = productRepository.findByCompany_Id(companyId);
        return products
                .stream()
                .map(ProductsDTO::new)
                .toList();
    }

    @Override
    public List<ProductsDTO> getAllProductsByCompanyIdAndCategory(Long companyId, String category) {
        List<Product> products = productRepository.findByCompany_IdAndCategory_Name(companyId, category);
        return products
                .stream()
                .map(ProductsDTO::new)
                .toList();
    }
}
