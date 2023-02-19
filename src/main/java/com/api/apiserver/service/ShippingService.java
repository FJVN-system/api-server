package com.api.apiserver.service;

//import com.api.apiserver.DTO.product.ProductsDTO;
import com.api.apiserver.DTO.product.ProductsDTO;
import com.api.apiserver.DTO.shipping.ShippingDTO;

import java.util.List;

public interface ShippingService {




    List<ShippingDTO> getAllProductsByCompanyIdAndUsersId(String companyId, Long userId);
}
