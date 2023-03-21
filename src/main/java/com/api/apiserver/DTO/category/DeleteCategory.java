package com.api.apiserver.DTO.category;

import lombok.*;

import javax.validation.constraints.NotNull;

public class DeleteCategory {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request {
        @NotNull
        private Long id;
        @NotNull
        private Long companyId;

        @NotNull
        private String categoryName;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response {
        private String categoryName;
        public static Response from(String categoryName) {
            return Response.builder()
                    .categoryName(categoryName)
                    .build();
        }
    }

}
