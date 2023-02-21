package com.api.apiserver.DTO.company;

import com.api.apiserver.domain.Company;
import com.api.apiserver.domain.Users;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyDTO {

    private Long id;
    private String companyName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static CompanyDTO fromEntity(Company company) {
        return CompanyDTO.builder()
                .id(company.getId())
                .companyName(company.getCompanyName())
                .createdAt(company.getCreatedAt())
                .updatedAt(company.getUpdatedAt())
                .build();
    }
}
