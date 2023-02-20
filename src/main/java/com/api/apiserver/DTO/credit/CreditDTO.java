package com.api.apiserver.DTO.credit;

import com.api.apiserver.domain.Credit;
import com.api.apiserver.domain.OrdersItem;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreditDTO {
    private Long id;
    private String content;
    private String memo;
    private Long deposit;
    private Long withdraw;
    private Long balance;
    private Long shippingId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static CreditDTO fromEntity(Credit credit) {
        return CreditDTO.builder()
                .id(credit.getId())
                .content(credit.getContent())
                .memo(credit.getMemo())
                .deposit(credit.getDeposit())
                .withdraw(credit.getWithdraw())
                .balance(credit.getBalance())
                .shippingId(credit.getShipping().getId())
                .createdAt(credit.getCreatedAt())
                .updatedAt(credit.getUpdatedAt())
                .build();
    }
}

