package com.api.apiserver.DTO.cartsitem;

import lombok.*;

import javax.validation.constraints.NotNull;

public class DeleteCartsItem {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request {
        @NotNull
        private Long usersId;

        @NotNull
        private Long cartItemId;

    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response {
        private String productTitle;
        public static Response from(CartsItemDTO cartsItemDTO) {
            return Response.builder()
                    .productTitle(cartsItemDTO.getProductTitle())
                    .build();
        }
    }

}
