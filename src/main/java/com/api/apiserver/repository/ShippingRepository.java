package com.api.apiserver.repository;

import com.api.apiserver.domain.Product;
import com.api.apiserver.domain.Shipping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ShippingRepository extends JpaRepository<Shipping, Long> {
    List<Shipping> findByCompany_IdAndUsers_Id(Long company_id, Long users_id);
}
