package com.api.apiserver.domain;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "company")
public class Company {

    @Id
    @Column(name = "company_id")
    private String id;

    @OneToMany(mappedBy = "company")
    private List<Users> users = new ArrayList<>();

    @OneToMany(mappedBy = "company")
    private List<Product> products = new ArrayList<>();

    @OneToMany(mappedBy = "company")
    private List<Artist> artists = new ArrayList<>();

    @OneToMany(mappedBy = "company")
    private List<StockHistory> stockHistories = new ArrayList<>();

    private String companyName;

    private String owner;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

}
