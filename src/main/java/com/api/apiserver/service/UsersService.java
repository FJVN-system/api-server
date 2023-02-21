package com.api.apiserver.service;


import com.api.apiserver.DTO.users.UsersDTO;
import com.api.apiserver.domain.Users;

import java.util.List;

public interface UsersService {
    List<UsersDTO> getAllUsers();
    Users getUser(Long userId);
    List<UsersDTO> getAllUsersByCompanyId(String companyId);
    UsersDTO createUser(String userName);
}
