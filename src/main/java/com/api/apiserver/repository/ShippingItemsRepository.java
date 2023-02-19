package com.api.apiserver.repository;

import com.api.apiserver.domain.Shipping;
import com.api.apiserver.domain.ShippingItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ShippingItemsRepository extends JpaRepository<ShippingItems, Long> {
    List<ShippingItems> findByShipping_Id(Long shipping_id);
}
