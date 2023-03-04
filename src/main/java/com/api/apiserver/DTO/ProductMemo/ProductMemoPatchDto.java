package com.api.apiserver.DTO.ProductMemo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductMemoPatchDto {

    private Long productMemoId;

    private LocalDateTime updatedAt;

    private String memoUser;

    private String content;

}
