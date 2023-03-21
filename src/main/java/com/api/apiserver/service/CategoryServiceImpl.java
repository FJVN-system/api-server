package com.api.apiserver.service;

import com.api.apiserver.DTO.artist.ArtistDTO;
import com.api.apiserver.DTO.category.CategoryDTO;
import com.api.apiserver.domain.Artist;
import com.api.apiserver.domain.Category;
import com.api.apiserver.repository.ArtistRepository;
import com.api.apiserver.repository.CategoryRepository;
import com.api.apiserver.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;
    private final CompanyRepository companyRepository;

    // TODO 테스트코드 작성필요
    @Override
    public List<CategoryDTO> getAllCategoryByCompanyId(Long companyId) {
        return categoryRepository.findByCompany_Id(companyId)
                .stream()
                .map(category -> CategoryDTO.fromEntity(category))
                .toList();
    }

    @Override
    public Category createCategory(String categoryName, Long companyId) {
        return categoryRepository.save(Category.builder()
                .name(categoryName)
                .company(companyRepository.findById(companyId))
                .build());
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Category getOrCreateCategoryByCompanyIdAndCategoryName(Long companyId, String categoryName) {
        Optional<Category> category = categoryRepository.findByCompany_IdAndName(companyId, categoryName);
        if (category.isPresent()){
            return category.get();
        }else {
            return createCategory(categoryName, companyId);
        }
    }
}
