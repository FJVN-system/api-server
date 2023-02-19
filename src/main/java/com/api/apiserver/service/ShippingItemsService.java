package com.api.apiserver.service;

//import com.api.apiserver.DTO.product.ProductsDTO;
import com.api.apiserver.DTO.shipping.ShippingDTO;
import com.api.apiserver.DTO.shippingitem.ShippingItemDTO;

import java.util.List;

public interface ShippingItemsService {

    List<ShippingItemDTO> getAllShippingItemsByShippingId(Long shippingId);
}
