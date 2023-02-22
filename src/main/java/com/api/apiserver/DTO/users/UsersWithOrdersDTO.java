package com.api.apiserver.DTO.users;

import com.api.apiserver.domain.Users;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsersWithOrdersDTO {

    private Long id;
    private String userName;

    private Long orders;
    private Long cartsItems;
    private Long shipping;
    private LocalDateTime createdAt;

//    public static UsersWithOrdersDTO fromEntity(Users users) {
//        return UsersWithOrdersDTO.builder()
//                .id(users.getId())
//                .companyId(users.getCompany().getId())
//                .companyName(users.getCompany().getCompanyName())
//                .userName(users.getUserName())
//                .createdAt(users.getCreatedAt())
//                .updatedAt(users.getUpdatedAt())
//                .build();
//    }
}
