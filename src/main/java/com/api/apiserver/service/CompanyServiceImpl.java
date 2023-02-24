package com.api.apiserver.service;

import com.api.apiserver.DTO.company.CompanyDTO;
import com.api.apiserver.DTO.users.UserDTO;
import com.api.apiserver.domain.Company;
import com.api.apiserver.domain.Users;
import com.api.apiserver.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService{

    private final CompanyRepository companyRepository;


    // TODO 테스트코드 작성필요
    @Override
    public CompanyDTO getCompany(Long companyId) {
        Company company = companyRepository.findById(companyId);
        return CompanyDTO.fromEntity(company);
    }

}
