package com.api.apiserver.repository;


import com.api.apiserver.domain.ProductMemo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ProductMemoRepository extends JpaRepository<ProductMemo, Long> {

    List<ProductMemo> findAllByProduct_Id(Long productId);

}
