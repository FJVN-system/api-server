package com.api.apiserver.service;


import com.api.apiserver.DTO.users.UsersDTO;

import java.util.List;

public interface UsersService {
    List<UsersDTO> getAllUsers();

    List<UsersDTO> getAllUsersByCompanyId(String companyId);

    UsersDTO createUser(String userName);
}
