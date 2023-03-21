package com.api.apiserver.DTO.product;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class CreateProduct {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request {
        @NotNull
        private String title;

        @NotNull
        private String barcode;
        @NotNull
        private Long price;

        @NotNull
        private String desc;

        @NotNull
        private Long purchase;
        @NotNull
        private LocalDateTime deadline;

        @NotNull
        private LocalDateTime release;

        @NotNull
        private String sku;
        @NotNull
        private Long stock;

        @NotNull
        private String thumb;
        @NotNull
        private Long weight;

        @NotNull
        private Long artist;
        @NotNull
        private Long category;
        @NotNull
        private Long ent;


    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response {
//        private Long userId;
        private String ok;

//        public static Response from(UsersDTO usersDTO) {
//            return Response.builder()
////                    .userId(usersDTO.getId())
//                    .userName(usersDTO.getUserName())
//                    .build();
//        }
    }

}
