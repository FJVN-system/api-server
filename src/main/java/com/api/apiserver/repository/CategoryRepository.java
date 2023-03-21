package com.api.apiserver.repository;

import com.api.apiserver.domain.Artist;
import com.api.apiserver.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findByCompany_Id(Long companyId);

    Optional<Category> findByCompany_IdAndName(Long companyId, String name);

}
