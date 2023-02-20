package com.api.apiserver.service;

//import com.api.apiserver.DTO.product.ProductsDTO;
import com.api.apiserver.DTO.credit.CreditDTO;
import com.api.apiserver.DTO.shipping.ShippingDTO;

import java.util.List;

public interface CreditService {

    List<CreditDTO> getAllCreditCompanyIdAndUsersId(String companyId, Long userId);
}
