package com.api.apiserver.service;

import com.api.apiserver.DTO.users.UsersDTO;
import com.api.apiserver.DTO.users.UsersWithOrdersDTO;
import com.api.apiserver.domain.Users;
import com.api.apiserver.exception.UserException;
import com.api.apiserver.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.api.apiserver.type.ErrorCode.USER_NOT_FOUND;

@Transactional
@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService{

    private final UsersRepository usersRepository;

    // TODO 테스트코드 작성필요
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

    // TODO 테스트코드 작성필요
    @Override
    public Users getUser(Long userId) {
        return usersRepository.findById(userId)
                .orElseThrow(()-> new UserException(USER_NOT_FOUND));
    }

    // TODO 테스트코드 작성필요
    @Override
    public UsersDTO getUserDTO(Long userId) {
        return UsersDTO.fromEntity(usersRepository.findById(userId)
                .orElseThrow(()-> new UserException(USER_NOT_FOUND)));
    }

    // TODO 테스트코드 작성필요
    @Override
    public List<UsersDTO> getAllUsers() {
        List<Users> usersList = usersRepository.findAll();
        return usersList
                .stream()
                .map(UsersDTO::fromEntity)
                .toList();
    }

    // TODO 테스트코드 작성필요
    @Override
    public List<UsersWithOrdersDTO> getAllUsersWithOrders(Long companyId) {
        List<UsersWithOrdersDTO> users = new ArrayList<>();
        List<Users> usersByCompanyId = getUsersByCompanyId(companyId);
        usersByCompanyId.forEach(usersD ->
            users.add(new UsersWithOrdersDTO(
                    usersD.getId(),
                    usersD.getUserName(),
                    usersD.getOrdersItems().stream().count(),
                    usersD.getCartsItems().stream().count(),
                    usersD.getShippings().stream().count(),
                    usersD.getCreatedAt())));
        return users;
    }

    // TODO 테스트코드 작성필요
    @Override
    public List<UsersDTO> getAllUsersByCompanyId(Long companyId) {
        List<Users> usersList = usersRepository.findByCompany_Id(companyId);
        return usersList
                .stream()
                .map(UsersDTO::fromEntity)
                .toList();
    }

    // TODO 테스트코드 작성필요
    @Override
    public List<Users> getUsersByCompanyId(Long companyId) {
        return usersRepository.findByCompany_Id(companyId);
    }
}
