package com.api.apiserver.service;

import com.api.apiserver.DTO.users.UsersDTO;
import com.api.apiserver.domain.Users;
import com.api.apiserver.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService{

    private final UsersRepository usersRepository;

    @Override
    public UsersDTO createUser(String userName) {
        return UsersDTO.fromEntity(
                usersRepository.save(Users.builder()
                        .userName(userName)
                        .createdAt(LocalDateTime.now())
                        .updatedAt(LocalDateTime.now())
                        .build())
        );
    }

    @Override
    public List<UsersDTO> getAllUsers() {
        List<Users> usersList = usersRepository.findAll();
        return usersList
                .stream()
                .map(UsersDTO::fromEntity)
                .toList();
    }

    @Override
    public List<UsersDTO> getAllUsersByCompanyId(String companyId) {
        List<Users> usersList = usersRepository.findByCompany_Id(companyId);
        return usersList
                .stream()
                .map(UsersDTO::fromEntity)
                .toList();
    }
}
