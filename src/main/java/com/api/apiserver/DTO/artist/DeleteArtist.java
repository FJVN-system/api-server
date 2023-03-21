package com.api.apiserver.DTO.artist;

import com.api.apiserver.DTO.cartsitem.CartsItemDTO;
import com.api.apiserver.domain.Artist;
import lombok.*;

import javax.validation.constraints.NotNull;

public class DeleteArtist {

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
        private String artistName;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response {
        private String artistName;
        public static Response from(String artistName) {
            return Response.builder()
                    .artistName(artistName)
                    .build();
        }
    }

}
