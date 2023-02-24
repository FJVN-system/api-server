package com.api.apiserver.service;

import com.api.apiserver.DTO.credit.CreditDTO;
import com.api.apiserver.DTO.shipping.ShippingDTO;
import com.api.apiserver.domain.Credit;
import com.api.apiserver.domain.Shipping;
import com.api.apiserver.repository.CreditRepository;
import com.api.apiserver.repository.ShippingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor
public class CreditServiceImpl implements CreditService{
    private final CreditRepository creditRepository;

    // TODO 테스트코드 작성필요
    @Override
    public List<CreditDTO> getAllCreditCompanyIdAndUsersId(Long companyId, Long userId) {
        List<Credit> creditList = creditRepository.findByCompany_IdAndUsers_Id(companyId, userId);
        return creditList
                .stream()
                .map(CreditDTO::fromEntity)
                .toList();
    }
}
