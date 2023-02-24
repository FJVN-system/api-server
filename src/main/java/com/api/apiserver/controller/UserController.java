package com.api.apiserver.controller;

import com.api.apiserver.DTO.users.CreateUsers;
import com.api.apiserver.DTO.users.UsersDTO;
import com.api.apiserver.DTO.users.UsersWithOrdersDTO;
import com.api.apiserver.service.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
public class UserController {

    private final UsersService usersService;

    // TODO 테스트코드 작성필요
    @GetMapping("/users")
    public ResponseEntity<List<UsersDTO>> getAllUsers() {
        return ResponseEntity.ok(usersService.getAllUsers());
    }

    // TODO 테스트코드 작성필요
    @GetMapping("/userswithorders/{companyId}")
    public ResponseEntity<List<UsersWithOrdersDTO>> getAllUsersWithOrders(
            @Valid @PathVariable("companyId") Long companyId
    ) {
        return ResponseEntity.ok(usersService.getAllUsersWithOrders(companyId));
    }

    // TODO 테스트코드 작성필요
    @GetMapping("/users/{userId}")
    public ResponseEntity<UsersDTO> getUser(
            @Valid @PathVariable("userId") Long userId) {
        return ResponseEntity.ok(usersService.getUserDTO(userId));
    }

    // TODO 테스트코드 작성필요
    @PostMapping("/users")
    public CreateUsers.Response createUser(
            @RequestBody @Valid CreateUsers.Request request
    ) {
        return CreateUsers.Response.from(
                usersService.createUser(request.getUserName()));
    }

    // TODO 테스트코드 작성필요
    @GetMapping("/usersbycompanyid/{companyId}")
    public ResponseEntity<List<UsersDTO>> getAllUsersByCompanyId(
            @Valid @PathVariable Long companyId
    ) {
        return ResponseEntity.ok(usersService.getAllUsersByCompanyId(companyId));
    }

}
