package com.api.apiserver.DTO.ProductMemo;

import com.api.apiserver.domain.Product;
import com.api.apiserver.domain.ProductMemo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductMemoDto {

    private Long productMemoId;

    private LocalDateTime createdAt;

    private Long usersId;

    private LocalDateTime updatedAt;


}
