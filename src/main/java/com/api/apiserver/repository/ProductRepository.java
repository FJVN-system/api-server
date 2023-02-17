package com.api.apiserver.repository;

import com.api.apiserver.domain.Category;
import com.api.apiserver.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCompany_Id(String company_id);

    List<Product> findByCompany_IdAndCategory_Name(String company_id, String category_name);



}
