package com.api.apiserver.DTO.ordersitem;

import com.api.apiserver.domain.CartsItem;
import com.api.apiserver.domain.OrdersItem;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrdersItemDTO {

    private Long id;
    private Long userId;
    private String userName;
    private String productTitle;
    private String barcode;
    private String sku;
    private Long price;
    private Long qty;
    private Long totalPrice;
    private Boolean shipped;
    private Boolean canceled;
    private Boolean picked;
    private Boolean deleted;
    private LocalDateTime releaseDate;
    private LocalDateTime preorderDeadline;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static OrdersItemDTO fromEntity(OrdersItem ordersItem) {
        return OrdersItemDTO.builder()
                .id(ordersItem.getId())
                .userId(ordersItem.getUsers().getId())
                .userName(ordersItem.getUsers().getUserName())
                .productTitle(ordersItem.getProduct().getTitle())
                .barcode(ordersItem.getProduct().getBarcode())
                .sku(ordersItem.getProduct().getSku())
                .price(ordersItem.getPrice())
                .qty(ordersItem.getQty())
                .totalPrice(ordersItem.getPrice() * ordersItem.getQty())
                .shipped(ordersItem.getShipped())
                .canceled(ordersItem.getCanceled())
                .picked(ordersItem.getPicked())
                .deleted(ordersItem.getDeleted())
                .releaseDate(ordersItem.getProduct().getReleaseDate())
                .preorderDeadline(ordersItem.getProduct().getPreorderDeadline())
                .createdAt(ordersItem.getCreatedAt())
                .updatedAt(ordersItem.getUpdatedAt())
                .build();
    }
}
