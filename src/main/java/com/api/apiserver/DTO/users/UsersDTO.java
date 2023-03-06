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
    private Long companyId;
    private String userName;
    private String userEmail;
    private String companyName;
    private String storeUrl;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static UsersDTO fromEntity(Users users) {
        return UsersDTO.builder()
                .id(users.getId())
                .companyId(users.getCompany().getId())
                .companyName(users.getCompany().getCompanyName())
                .storeUrl(users.getCompany().getStoreUrl())
                .userName(users.getUserName())
                .userEmail(users.getUserEmail())
                .createdAt(users.getCreatedAt())
                .updatedAt(users.getUpdatedAt())
                .build();
    }
}
