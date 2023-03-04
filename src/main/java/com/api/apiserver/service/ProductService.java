package com.api.apiserver.service;

//import com.api.apiserver.DTO.product.ProductsDTO;
import com.api.apiserver.DTO.product.ProductsDTO;
import com.api.apiserver.domain.Product;
import com.api.apiserver.domain.Users;

import java.util.List;

public interface ProductService {

    List<ProductsDTO> getAllProducts();

    Product getProduct(Long productId);

    List<ProductsDTO> getAllProductsByCompanyId(Long companyId);

    List<ProductsDTO> getAllProductsByCompanyIdAndCategory(Long companyId, String category);
}
