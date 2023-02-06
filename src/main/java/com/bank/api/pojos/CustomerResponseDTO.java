package com.bank.api.pojos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
@Setter
public class CustomerResponseDTO {


    private Long id;

    private String name;

    private String email;

    private String phoneNumber;

    private String address;

    private LocalDate dateOfBirth;

    private LocalDateTime dateCreated;
    private LocalDateTime lastUpdated;

}
