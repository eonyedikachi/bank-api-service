package com.bank.api.pojos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountUpdateRequestDTO {


    @NotNull(message = "Customer ID must be provided")
    @Schema(type = "int", example = "1")
    private Long customerId;

    @NotNull(message = "Account number must be provided")
//    @Size(min = 12, max = 12, message = "Account number must be twelve (12) digits")
    @Schema(type = "string", example = "1234567890")
    private String accountNumber;

    @NotNull(message = "Account pin must not be provided")
    @Size(max = 4, min = 4, message = "Pin must be four (4) digits")
    @Schema(type = "int", example = "1234")
    private int accountPin;


    @NotNull(message = "Account new pin must not be provided")
    @Digits(integer = 4, fraction=0, message = "New pin must be four (4) digits")
    @Schema(type = "int", example = "1234")
    private int newAccountPin;

}
