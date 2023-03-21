package com.api.apiserver.DTO.category;

import com.api.apiserver.domain.Artist;
import com.api.apiserver.domain.Category;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryDTO {

    private Long id;
    private String categoryName;
    private Long companyId;

    public static CategoryDTO fromEntity(Category category) {
        return CategoryDTO.builder()
                .id(category.getId())
                .categoryName(category.getName())
                .companyId(category.getCompany().getId())
                .build();
    }
}
