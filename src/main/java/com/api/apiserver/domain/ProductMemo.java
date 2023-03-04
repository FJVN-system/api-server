package com.api.apiserver.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Setter
@Builder
@Table(name = "productmemo")
public class ProductMemo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productMemo_id")
    private Long productMemoId;

    @JsonIgnore
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @JsonIgnore
    @JoinColumn(name = "users_id")
    @ManyToOne
    private Users users;


    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    private String content;

    public ProductMemo(Product product, LocalDateTime createdAt,
                       Users users, LocalDateTime updatedAt,
                       String content) {

        this.product = product;
        this.createdAt = createdAt;
        this.users = users;
        this.updatedAt = updatedAt;
        this.content = content;
    }
}
