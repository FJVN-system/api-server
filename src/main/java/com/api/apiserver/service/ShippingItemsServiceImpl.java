package com.api.apiserver.service;

import com.api.apiserver.DTO.shipping.ShippingDTO;
import com.api.apiserver.DTO.shippingitem.ShippingItemDTO;
import com.api.apiserver.domain.Shipping;
import com.api.apiserver.domain.ShippingItems;
import com.api.apiserver.repository.ShippingItemsRepository;
import com.api.apiserver.repository.ShippingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor
public class ShippingItemsServiceImpl implements ShippingItemsService{
    private final ShippingItemsRepository shippingItemsRepository;

    // TODO 테스트코드 작성필요
    @Override
    public List<ShippingItemDTO> getAllShippingItemsByShippingId(Long shippingId) {
        List<ShippingItems> shippingList = shippingItemsRepository.findByShipping_Id(shippingId);
        return shippingList
                .stream()
                .map(ShippingItemDTO::new)
                .toList();
    }
}
