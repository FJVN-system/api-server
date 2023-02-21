package com.api.apiserver.controller;

import com.api.apiserver.DTO.company.CompanyDTO;
import com.api.apiserver.service.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping("/company/{companyId}")
    public ResponseEntity<CompanyDTO> getCompany(
            @Valid @PathVariable("companyId") Long companyId) {
        return ResponseEntity.ok(companyService.getCompany(companyId));
    }
}
