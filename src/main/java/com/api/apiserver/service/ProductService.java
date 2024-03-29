package com.api.apiserver.service;

//import com.api.apiserver.DTO.product.ProductsDTO;
import com.api.apiserver.DTO.product.CreateProduct;
import com.api.apiserver.DTO.product.CreateProductBulk;
import com.api.apiserver.DTO.product.ProductsDTO;
import com.api.apiserver.domain.Product;

import java.util.List;

public interface ProductService {

    List<ProductsDTO> getAllProducts();

    Product getProduct(Long productId);

    List<ProductsDTO> getAllProductsByCompanyId(Long companyId);

    List<ProductsDTO> getAllProductsByCompanyIdAndCategory(Long companyId, String category);

    List<Product> createProductsBulk(List<CreateProductBulk.Request> requests, Long companyId);
    Product createProduct(CreateProduct.Request requests, Long companyId);
}
