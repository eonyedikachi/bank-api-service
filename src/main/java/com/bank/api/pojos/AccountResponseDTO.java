package com.bank.api.pojos;

import com.bank.api.enums.AccountType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Getter
@Setter
public class AccountResponseDTO {
    private Long customerId;
    private String customerName;
    private String accountNumber;
    private BigDecimal currentBalance;
    private AccountType accountType;
    private LocalDateTime dateCreated;
    private LocalDateTime lastUpdated;


}
