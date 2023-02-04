package com.bank.api.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class CustomerEntity {

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
    @Column(nullable = false)
    private String name;

    @NotNull
    @Column(nullable = false)
    private String email;

    @NotNull
    @Column(nullable = false, length = 13)
    private String phoneNumber;

    @NotNull
    @Column
    private String address;

    @NotNull
    @Column(nullable = false)
    private LocalDate dateOfBirth;

    @OneToMany(mappedBy = "accountCustomer")
    private Set<AccountEntity> customerAccounts;


    @Column(nullable = false, updatable = false)
    private LocalDateTime dateCreated;

    @Column
    private LocalDateTime lastUpdated;

}