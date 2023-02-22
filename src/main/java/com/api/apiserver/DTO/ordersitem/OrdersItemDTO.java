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
    private Long price;
    private Long qty;
    private Boolean shipped;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static OrdersItemDTO fromEntity(OrdersItem ordersItem) {
        return OrdersItemDTO.builder()
                .id(ordersItem.getId())
                .userId(ordersItem.getUsers().getId())
                .userName(ordersItem.getUsers().getUserName())
                .productTitle(ordersItem.getProduct().getTitle())
                .price(ordersItem.getPrice())
                .qty(ordersItem.getQty())
                .shipped(ordersItem.getShipped())
                .createdAt(ordersItem.getCreatedAt())
                .updatedAt(ordersItem.getUpdatedAt())
                .build();
    }
}
