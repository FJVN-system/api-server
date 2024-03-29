package com.api.apiserver.service;

//import com.api.apiserver.DTO.product.ProductsDTO;
import com.api.apiserver.DTO.product.ProductsDTO;
import com.api.apiserver.DTO.shipping.ShippingDTO;

import java.util.List;

public interface ShippingService {




    List<ShippingDTO> getAllProductsByCompanyIdAndUsersId(Long companyId, Long userId);

    List<ShippingDTO> getAllShippingByCompanyId(Long companyId);
}
