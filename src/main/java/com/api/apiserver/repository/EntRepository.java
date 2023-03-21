package com.api.apiserver.repository;

import com.api.apiserver.domain.Artist;
import com.api.apiserver.domain.Ent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EntRepository extends JpaRepository<Ent, Long> {
    List<Ent> findByCompany_Id(Long companyId);

    Optional<Ent> findByCompany_IdAndName(Long companyId, String name);

}
