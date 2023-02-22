package com.api.apiserver.repository;

import com.api.apiserver.domain.CartsItem;
import com.api.apiserver.domain.OrdersItem;
import com.api.apiserver.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartsItemRepository extends JpaRepository<CartsItem, String> {

    Optional<CartsItem> findById(Long cartId);

    void deleteById(Long id);

    List<CartsItem> findByUsers_Id(Long userId);
    List<CartsItem> findByUsers_IdAndProduct_Id(Long userId, Long productId);

    List<CartsItem> findAllByUsers_Id(Long userId);
}
