package com.api.apiserver.DTO.users;

import com.api.apiserver.domain.Users;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {

    private Long id;
    private String userName;
    private String companyName;
    private Long companyId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static UserDTO fromEntity(Users users) {
        return UserDTO.builder()
                .id(users.getId())
                .companyName(users.getCompany().getCompanyName())
                .companyId(users.getCompany().getId())
                .userName(users.getUserName())
                .createdAt(users.getCreatedAt())
                .updatedAt(users.getUpdatedAt())
                .build();
    }
}
