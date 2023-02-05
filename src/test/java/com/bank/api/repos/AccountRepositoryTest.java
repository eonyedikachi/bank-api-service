package com.bank.api.repos;

import com.bank.api.entities.AccountEntity;
import com.bank.api.enums.AccountType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;


import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class AccountRepositoryTest {

    @Autowired
    private AccountRepository accountRepo;

    @AfterEach
    void tearDown(){
        accountRepo.deleteAll();
    }

    @Test
    @DisplayName("findByAccountNumber should return account record when valid Account Number is passed")
    void shouldReturnAccountByAccountNumber() {
        //given
        String accountNumber = "1234567890";

        AccountEntity account = new AccountEntity();

        account.setId(1L);
        account.setAccountNumber(accountNumber);
        account.setAccountPin("48rfubf984bnf uhdfbnsdf jnc jnk");
        account.setAccountType(AccountType.SAVINGS);
        account.setCurrentBalance(new BigDecimal("12000"));
        account.setDateCreated(LocalDateTime.now());

        account = accountRepo.save(account);

        //when
        AccountEntity expected = accountRepo.findByAccountNumber(accountNumber).get();

        //then
        assertThat(expected).isEqualTo(account);

    }

    @Test
    @DisplayName("findByAccountNumber should return not account record when invalid Account Number is passed")
    void shouldNotReturnAccountIfAccountNumberIsInvalid() {
        //given
        String accountNumber = "1234567890";

        AccountEntity account = new AccountEntity();

        account.setId(2L);
        account.setAccountNumber("1987654321");
        account.setAccountPin("48rfubf984bnf uhdfbnsdf jnc jnk");
        account.setAccountType(AccountType.SAVINGS);
        account.setCurrentBalance(new BigDecimal("12000"));
        account.setDateCreated(LocalDateTime.now());

        accountRepo.save(account);

        //when
        boolean expected = accountRepo.findByAccountNumber(accountNumber).isPresent();

        //then
        assertThat(expected).isFalse();

    }

}