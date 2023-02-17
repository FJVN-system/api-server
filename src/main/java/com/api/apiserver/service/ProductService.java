package com.api.apiserver.service;

//import com.api.apiserver.DTO.product.ProductsDTO;
import com.api.apiserver.DTO.product.ProductsDTO;

import java.util.List;

public interface ProductService {

    List<ProductsDTO> getAllProducts();


    List<ProductsDTO> getAllProductsByCompanyId(String companyId);

    List<ProductsDTO> getAllProductsByCompanyIdAndCategory(String companyId, String category);
}
