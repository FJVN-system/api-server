package com.api.apiserver.repository;

import com.api.apiserver.domain.CartsItem;
import com.api.apiserver.domain.OrdersItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersItemRepository extends JpaRepository<OrdersItem, String> {
    List<OrdersItem> findByUsers_Id(Long userId);
}
