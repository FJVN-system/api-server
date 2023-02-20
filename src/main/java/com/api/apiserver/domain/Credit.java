package com.api.apiserver.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.FetchType.LAZY;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "credit")
public class Credit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "credit_id")
    private Long id;

    @JsonIgnore
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "users_id")
    private Users users;

    @JsonIgnore
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "shipping_id")
    private Shipping shipping;

    private String content;

    private String memo;

    private Long deposit;

    private Long withdraw;

    private Long balance;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;


}
