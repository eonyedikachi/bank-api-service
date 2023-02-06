package com.bank.api.pojos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
public class CustomerUpdateRequestDTO {


    @NotNull(message = "Customer ID must be provided")
    @Schema(type = "int", example = "1")
    private Long id;

    @Size(max = 255)
    @Schema(type = "string", example = "John Paul")
    private String name;


    @Size(max = 255)
    @Schema(type = "string", example = "john@gmail.com")
    private String email;


//    @Size(max = 13, min=13, message = "Phone number must be 13 digits")
    @Schema(type = "string", example = "1234567890")
    private String phoneNumber;


    @Size(max = 255)
    @Schema(type = "string", example = "Lagos")
    private String address;

    @Schema(type = "string", example = "2023-01-28")
    private LocalDate dateOfBirth;

}
