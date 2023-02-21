package com.api.apiserver.service;

import com.api.apiserver.DTO.product.ProductsDTO;
import com.api.apiserver.DTO.shipping.ShippingDTO;
import com.api.apiserver.domain.Product;
import com.api.apiserver.domain.Shipping;
import com.api.apiserver.repository.ProductRepository;
import com.api.apiserver.repository.ShippingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor
public class ShippingServiceImpl implements ShippingService{


    private final ShippingRepository shippingRepository;

    @Override
    public List<ShippingDTO> getAllProductsByCompanyIdAndUsersId(Long companyId, Long userId) {
        List<Shipping> shippingList = shippingRepository.findByCompany_IdAndUsers_Id(companyId, userId);
        return shippingList
                .stream()
                .map(ShippingDTO::new)
                .toList();
    }
}
