package com.api.apiserver.DTO.shippingitem;

import com.api.apiserver.domain.Shipping;
import com.api.apiserver.domain.ShippingItems;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ShippingItemDTO {
    private Long id;
    private Long shippingId;
    private String userName;
    private String productName;

    private Long price;

    private Long qty;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public ShippingItemDTO(ShippingItems shippingItems) {
        this.id = shippingItems.getId();
        this.shippingId = shippingItems.getShipping().getId();
        this.userName = shippingItems.getUsers().getUserName();
        this.productName = shippingItems.getProduct().getTitle();
        this.price = shippingItems.getPrice();
        this.qty = shippingItems.getQty();
        this.createdAt = shippingItems.getCreatedAt();
        this.updatedAt = shippingItems.getUpdatedAt();
    }
}
