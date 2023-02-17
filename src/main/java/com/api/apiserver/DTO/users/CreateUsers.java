package com.api.apiserver.DTO.users;

import lombok.*;
import javax.validation.constraints.NotNull;

public class CreateUsers {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request {
        @NotNull
        private String userName;

    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response {
        private Long userId;
        private String userName;

        public static Response from(UsersDTO usersDTO) {
            return Response.builder()
//                    .userId(usersDTO.getId())
                    .userName(usersDTO.getUserName())
                    .build();
        }
    }

}
