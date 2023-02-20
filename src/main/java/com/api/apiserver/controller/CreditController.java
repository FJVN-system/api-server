package com.api.apiserver.controller;

import com.api.apiserver.DTO.credit.CreditDTO;
import com.api.apiserver.DTO.shipping.ShippingDTO;
import com.api.apiserver.domain.Credit;
import com.api.apiserver.service.CreditService;
import com.api.apiserver.service.ShippingService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;


@RestController
@AllArgsConstructor
public class CreditController {

    private final CreditService creditService;

    @GetMapping("/credit/{companyId}/{userId}")
    public ResponseEntity<List<CreditDTO>> getAllCreditCompanyIdAndUsersId(
            @Valid @PathVariable("companyId") String companyId,
            @Valid @PathVariable("userId") Long userId) {
        return ResponseEntity.ok(creditService.getAllCreditCompanyIdAndUsersId(companyId, userId));
    }

}
