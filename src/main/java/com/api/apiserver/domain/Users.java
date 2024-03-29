package com.api.apiserver.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "users_id")
    private Long id;

    @NotNull
    @Column(name = "users_name", unique = true)
    private String userName;

    @NotNull
    @Column(name = "users_email", unique = true)
    private String userEmail;

    @JsonIgnore
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "company_id")
    private Company company;


    @OneToMany(mappedBy = "users")
    private List<ProductMemo> productMemos = new ArrayList<>();

    @OneToMany(mappedBy = "users")
    private List<CartsItem> cartsItems = new ArrayList<>();

    @OneToMany(mappedBy = "users")
    private List<OrdersItem> ordersItems = new ArrayList<>();

    @OneToMany(mappedBy = "users")
    private List<Shipping> shippings = new ArrayList<>();

    @OneToMany(mappedBy = "users")
    private List<Address> addresses = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "discountbyuser_id")
    private DiscountByUser discountByUser;

    @OneToMany(mappedBy = "users")
    private List<DiscountByCategory> discountByCategories = new ArrayList<>();

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

}
