package com.api.apiserver.DTO.cartsitem;

import lombok.*;

import javax.validation.constraints.NotNull;

public class ModifyCartsItem {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request {
        @NotNull
        private Long usersId;
        @NotNull
        private Long cartItemId;
        @NotNull
        private Long qty;

    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response {
        private String productTitle;
        private Long qty;
        private Long price;

        public static Response from(CartsItemDTO cartsItemDTO) {
            return Response.builder()
                    .productTitle(cartsItemDTO.getProductTitle())
                    .qty(cartsItemDTO.getQty())
                    .price(cartsItemDTO.getPrice())
                    .build();
        }
    }

}
