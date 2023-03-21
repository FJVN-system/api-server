package com.api.apiserver.service;


import com.api.apiserver.DTO.artist.ArtistDTO;
import com.api.apiserver.DTO.category.CategoryDTO;
import com.api.apiserver.domain.Artist;
import com.api.apiserver.domain.Category;

import java.util.List;

public interface CategoryService {
    List<CategoryDTO> getAllCategoryByCompanyId(Long companyId);

    Category createCategory(String categoryName, Long companyId);

    void deleteCategory(Long id);
}
