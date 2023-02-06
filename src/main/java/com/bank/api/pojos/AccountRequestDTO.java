package com.bank.api.pojos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.bank.api.enums.AccountType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class AccountRequestDTO {

    @NotNull(message = "Customer ID must be provided")
    @Schema(type = "int", example = "1")
    private Long customerId;

    @NotNull(message = "Opening balance must be provided")
    @DecimalMin(value = "0.00")
    @Digits(integer = 16, fraction = 2, message = "Use this format <100.00>")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @Schema(type = "double", example = "69.08")
    private BigDecimal openingBalance;

    @NotNull(message = "Specify account type: savings or current")
    @Schema(type = "string", example = "savings")
    private AccountType accountType;

    @NotNull(message = "Account PIN must be provided")
    @Digits(integer = 4, fraction=0, message = "New pin must be four (4) digits")
    @Schema(type = "int", example = "1234")
    private int accountPin;

}
