package com.api.apiserver.repository;

import com.api.apiserver.domain.CartsItem;
import com.api.apiserver.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartsItemRepository extends JpaRepository<CartsItem, String> {
    List<CartsItem> findByUsers_Id(Long userId);
    List<CartsItem> findByUsers_IdAndProduct_Id(Long userId, Long productId);
}
