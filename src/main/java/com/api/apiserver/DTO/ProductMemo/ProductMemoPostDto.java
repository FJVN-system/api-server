package com.api.apiserver.DTO.ProductMemo;


import com.api.apiserver.domain.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductMemoPostDto {

    private Long productId;

    private String memo;

    private Long usersId;
}
