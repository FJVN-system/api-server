package com.api.apiserver.service;


import com.api.apiserver.DTO.company.CompanyDTO;
import com.api.apiserver.DTO.users.UserDTO;
import com.api.apiserver.DTO.users.UsersDTO;

import java.util.List;

public interface CompanyService {
     CompanyDTO getCompany(Long companyId);

}
