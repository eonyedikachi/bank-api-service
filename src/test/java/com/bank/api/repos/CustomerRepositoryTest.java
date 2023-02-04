package com.bank.api.repos;

import com.bank.api.entities.CustomerEntity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepoTest;

    @AfterEach
    void tearDown(){
        customerRepoTest.deleteAll();
    }

    @Test
    void shouldReturnTrueIfExistsByEmail() {
        //given
        String email = "john_james@gmail.com";

        CustomerEntity customer = new CustomerEntity();
        customer.setId(1L);
        customer.setName( "John James");
        customer.setEmail(email);
        customer.setPhoneNumber("2341234567890");
        customer.setAddress("Lagos, Nigeria");
        customer.setDateOfBirth(LocalDate.of(1984, 12, 10));
        customer.setDateCreated(LocalDateTime.now());

        customerRepoTest.save(customer);

        //when
        boolean expected = customerRepoTest.existsByEmail(email);

        //then
        assertThat(expected).isTrue();
    }
}