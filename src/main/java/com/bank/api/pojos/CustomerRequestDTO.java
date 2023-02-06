package com.bank.api.pojos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CustomerRequestDTO {


    @NotNull(message = "Customer name must be provided")
    @Size(max = 255)
    private String name;


    @NotNull(message = "Customer email must be provided")
    @Email(message="Email is not valid", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    @Size(max = 255)
    private String email;


    @NotNull(message = "Customer phoneNumber must be provided")
//    @Size(max = 13, min=13, message = "Phone number must be 13 digits")
    @Schema(type = "string", example = "1234567890890")
    private String phoneNumber;


    @NotNull(message = "Customer address must be provided")
    @Size(max = 255)
    @Schema(type = "string", example = "Lagos")
    private String address;


    @NotNull(message = "Customer date of birth must be provided")
    @Schema(type = "string", example = "2023-01-28")
    private LocalDate dateOfBirth;
}
