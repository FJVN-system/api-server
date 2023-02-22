package com.api.apiserver.service;


import com.api.apiserver.DTO.users.UsersDTO;
import com.api.apiserver.DTO.users.UsersWithOrdersDTO;
import com.api.apiserver.domain.Users;

import java.util.List;

public interface UsersService {
    List<UsersDTO> getAllUsers();
    Users getUser(Long userId);
    UsersDTO getUserDTO(Long userId);
    List<UsersDTO> getAllUsersByCompanyId(Long companyId);
    UsersDTO createUser(String userName);
    List<UsersWithOrdersDTO> getAllUsersWithOrders(Long companyId);

    List<Users> getUsersByCompanyId(Long companyId);
}
