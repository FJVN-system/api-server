package com.api.apiserver.DTO.category;

import com.api.apiserver.domain.Artist;
import com.api.apiserver.domain.Category;
import lombok.*;

import javax.validation.constraints.NotNull;

public class CreateCategory {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request {

        @NotNull
        private String categoryName;

        @NotNull
        private Long companyId;

    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response {
        private String categoryName;
        public static Response from(Category category) {
            return Response.builder()
                    .categoryName(category.getName())
                    .build();
        }
    }

}
