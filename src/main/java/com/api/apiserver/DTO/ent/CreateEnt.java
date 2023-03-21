package com.api.apiserver.DTO.ent;

import com.api.apiserver.domain.Artist;
import com.api.apiserver.domain.Ent;
import lombok.*;

import javax.validation.constraints.NotNull;

public class CreateEnt {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request {

        @NotNull
        private String entName;

        @NotNull
        private Long companyId;

    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response {
        private String entName;
        public static Response from(Ent ent) {
            return Response.builder()
                    .entName(ent.getName())
                    .build();
        }
    }

}
