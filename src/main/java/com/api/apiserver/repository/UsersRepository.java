package com.api.apiserver.repository;

import com.api.apiserver.domain.Company;
import com.api.apiserver.domain.Users;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<Users, String> {

    List<Users> findByCompany_Id(String company_id);

    Users findById(Long users_id);
}
