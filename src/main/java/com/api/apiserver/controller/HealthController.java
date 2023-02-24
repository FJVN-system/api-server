package com.api.apiserver.controller;

import com.api.apiserver.DTO.cartsitem.CartsItemDTO;
import com.api.apiserver.service.CartsItemService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
public class HealthController {

    // TODO 테스트코드 작성필요
    @GetMapping("/healthcheck")
    public ResponseEntity<String> healthcheck() {
        return ResponseEntity.ok("ok");
    }

}
