package com.api.apiserver.repository;

import com.api.apiserver.domain.Artist;
import com.api.apiserver.domain.CartsItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {
    List<Artist> findByCompany_Id(Long companyId);
}
