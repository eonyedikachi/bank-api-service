package com.bank.api.entities;

import com.bank.api.enums.AccountType;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class AccountEntity {

    @Id
    @Column(nullable = false, updatable = false)
    @SequenceGenerator(
            name = "primary_sequence",
            sequenceName = "primary_sequence",
            allocationSize = 1,
            initialValue = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "primary_sequence"
    )
    private Long id;

    @NotNull
    @Column(nullable = false, unique = true)
    private String accountNumber;

    @NotNull
    @Column(nullable = false)
    private String accountPin;

    @NotNull
    @Column(nullable = false, precision = 16, scale = 2)
    private BigDecimal currentBalance;

    @Column
    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "account_customer_id")
    private CustomerEntity accountCustomer;

    @NotNull
    @Column(nullable = false, updatable = false)
    private LocalDateTime dateCreated;

    @Column
    private LocalDateTime lastUpdated;

}