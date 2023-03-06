package com.api.apiserver.DTO.shipping;

import com.api.apiserver.domain.Shipping;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ShippingDTO {

    private Long id;
    private String companyName;
    private String userName;
    private Long totalPrice;
    private Long shippingPrice;
    private Long itemsPrice;
    private Long totalCount;
    private Long itemsCount;
    private String trackingNumber;
    private String ShippedAddressName;
    private String shippingType;
    private LocalDateTime shippedAt;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ShippingDTO(Shipping shipping) {
        this.id = shipping.getId();
        this.companyName = shipping.getCompany().getCompanyName();
        this.userName = shipping.getUsers().getUserName();
        this.totalPrice = shipping.getTotalPrice();
        this.shippingPrice = shipping.getShippingPrice();
        this.itemsPrice = shipping.getItemsPrice();
        this.totalCount = shipping.getTotalCount();
        this.itemsCount = shipping.getItemsCount();
        this.trackingNumber = shipping.getTrackingNumber();
        this.ShippedAddressName = shipping.getShippedAddressName();
        this.shippingType = shipping.getShippingType();
        this.shippedAt = shipping.getShippedAt();
        this.createdAt = shipping.getCreatedAt();
        this.updatedAt = shipping.getUpdatedAt();
    }
}
