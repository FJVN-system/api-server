package com.api.apiserver.controller;

import com.api.apiserver.DTO.users.CreateUsers;
import com.api.apiserver.DTO.users.UserDTO;
import com.api.apiserver.DTO.users.UsersDTO;
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

    @GetMapping("/users")
    public ResponseEntity<List<UsersDTO>> getAllUsers() {
        return ResponseEntity.ok(usersService.getAllUsers());
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<UserDTO> getUser(
            @Valid @PathVariable("userId") Long userId) {
        return ResponseEntity.ok(usersService.getUser(userId));
    }

    @PostMapping("/users")
    public CreateUsers.Response createUser(
            @RequestBody @Valid CreateUsers.Request request
    ) {
        return CreateUsers.Response.from(
                usersService.createUser(
                        request.getUserName()));
    }

    @GetMapping("/usersbycompanyid/{companyId}")
    public ResponseEntity<List<UsersDTO>> getAllUsersByCompanyId(
            @Valid @PathVariable String companyId
    ) {
        return ResponseEntity.ok(usersService.getAllUsersByCompanyId(companyId));
    }

}
