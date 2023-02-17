package com.api.apiserver.DTO.users;

import com.api.apiserver.domain.Users;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsersDTO {

    private Long id;
    private String userName;
    private String companyName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static UsersDTO fromEntity(Users users) {
        return UsersDTO.builder()
                .id(users.getId())
                .userName(users.getUserName())
                .createdAt(users.getCreatedAt())
                .updatedAt(users.getUpdatedAt())
                .build();
    }
}
