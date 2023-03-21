package com.api.apiserver.controller;

import com.api.apiserver.DTO.artist.ArtistDTO;
import com.api.apiserver.DTO.artist.CreateArtist;
import com.api.apiserver.DTO.artist.DeleteArtist;
import com.api.apiserver.DTO.category.CategoryDTO;
import com.api.apiserver.DTO.category.CreateCategory;
import com.api.apiserver.DTO.category.DeleteCategory;
import com.api.apiserver.domain.Category;
import com.api.apiserver.service.ArtistService;
import com.api.apiserver.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;
    // TODO 테스트코드 작성필요
    @GetMapping("/{companyId}/category")
    public ResponseEntity<List<CategoryDTO>> getAllCategory(
            @Valid @PathVariable("companyId") Long companyId) {

        return ResponseEntity.ok(categoryService.getAllCategoryByCompanyId(companyId));
    }

    // TODO 테스트코드 작성필요
    @PostMapping("/{companyId}/category")
    public ResponseEntity<CreateCategory.Response>  createCategory(
            @RequestBody @Valid CreateCategory.Request request,
            @Valid @PathVariable("companyId") Long companyId) {
        return ResponseEntity.ok(CreateCategory.Response.from(
                categoryService.createCategory(request.getCategoryName(), companyId)));
    }

    // TODO 테스트코드 작성필요
    @DeleteMapping("/{companyId}/category")
    public ResponseEntity<DeleteCategory.Response>  DeleteCategory(
            @RequestBody @Valid DeleteCategory.Request request) {
        categoryService.deleteCategory(request.getId());
        return ResponseEntity.ok(DeleteCategory.Response.from(request.getCategoryName()));
    }

}
