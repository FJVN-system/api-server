package com.api.apiserver.service;


import com.api.apiserver.DTO.users.UserDTO;
import com.api.apiserver.DTO.users.UsersDTO;

import java.util.List;

public interface UsersService {
    List<UsersDTO> getAllUsers();
    UserDTO getUser(Long userId);

    List<UsersDTO> getAllUsersByCompanyId(String companyId);

    UsersDTO createUser(String userName);
}
