package com.api.apiserver.DTO.ent;

import lombok.*;

import javax.validation.constraints.NotNull;

public class DeleteEnt {

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
        private String entName;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response {
        private String entName;
        public static Response from(String entName) {
            return Response.builder()
                    .entName(entName)
                    .build();
        }
    }

}
