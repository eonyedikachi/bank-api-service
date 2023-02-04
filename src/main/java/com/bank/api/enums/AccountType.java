package com.bank.api.enums;


import com.fasterxml.jackson.annotation.JsonValue;

import java.math.BigDecimal;

public enum AccountType {

    SAVINGS("savings",  0.042),
    CURRENT("current", 0.025);

    private String type;
    private double interestRate;

    AccountType(String type, double interestRate) {
        this.type = type;
        this.interestRate = interestRate;
    }

    @JsonValue
    public String getType() {
        return this.type;
    }

    public double getInterestRate() {
        return this.interestRate;
    }

}