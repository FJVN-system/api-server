package com.api.apiserver.DTO.cartsitem;

import com.api.apiserver.domain.CartsItem;
import com.api.apiserver.domain.Users;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartsItemDTO {

    private Long id;
    private String productTitle;
    private Long price;
    private Long qty;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static CartsItemDTO fromEntity(CartsItem cartsItem) {
        return CartsItemDTO.builder()
                .id(cartsItem.getId())
                .productTitle(cartsItem.getProduct().getTitle())
                .price(cartsItem.getPrice())
                .qty(cartsItem.getQty())
                .createdAt(cartsItem.getCreatedAt())
                .updatedAt(cartsItem.getUpdatedAt())
                .build();
    }
}
