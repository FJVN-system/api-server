package com.api.apiserver.domain;

import com.api.apiserver.type.CompanyLevel;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.api.apiserver.type.CompanyLevel.DEMO;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private Long id;

    @OneToMany(mappedBy = "company")
    private List<Users> users = new ArrayList<>();

    @OneToMany(mappedBy = "company")
    private List<Shipping> shippings = new ArrayList<>();

    @OneToMany(mappedBy = "company")
    private List<Product> products = new ArrayList<>();

    @OneToMany(mappedBy = "company")
    private List<OrdersItem> ordersItems = new ArrayList<>();

    @OneToMany(mappedBy = "company")
    private List<Artist> artists = new ArrayList<>();

    @OneToMany(mappedBy = "company")
    private List<StockHistory> stockHistories = new ArrayList<>();

    @OneToMany(mappedBy = "company")
    private List<DiscountByUser> discountByUsers = new ArrayList<>();

    @OneToMany(mappedBy = "company")
    private List<DiscountByCategory> discountByCategories = new ArrayList<>();

    @NotNull
    @Column(name = "company_name",unique = true)
    private String companyName;

    @NotNull
    private String owner;

    private String storeUrl;

    @Enumerated(EnumType.STRING)
    private CompanyLevel companyLevel;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

}
