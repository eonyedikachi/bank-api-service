package com.bank.api.service.impl;

import com.bank.api.entities.CustomerEntity;
import com.bank.api.exceptions.InvalidValueException;
import com.bank.api.pojos.CustomerRequestDTO;
import com.bank.api.pojos.CustomerResponseDTO;
import com.bank.api.repos.CustomerRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {

    @Mock
    private CustomerRepository customerRepo;

    @InjectMocks
    private CustomerServiceImpl serviceTest;

    @Test
    @DisplayName("createCustomer should create new customer record and return customer response object")
    void shouldCreateNewCustomer() {
        //given
        LocalDateTime dateCreated = LocalDateTime.now();
        LocalDate dateOfBirth = LocalDate.of(1974, 12, 10);

        CustomerRequestDTO customerRequest = new CustomerRequestDTO();
        customerRequest.setName( "Tobi Ola");
        customerRequest.setEmail("tobi.ola@bank.com");
        customerRequest.setPhoneNumber("2341782345690");
        customerRequest.setAddress("Lagos, Nigeria");
        customerRequest.setDateOfBirth(dateOfBirth);


        CustomerEntity entity = new CustomerEntity();
        Long expectedId = 1L;
        entity.setId(expectedId);
        entity.setName( "Tobi Ola");
        entity.setEmail("tobi.ola@bank.com");
        entity.setPhoneNumber("2341782345690");
        entity.setAddress("Lagos, Nigeria");
        entity.setDateOfBirth(dateOfBirth);
        entity.setDateCreated(dateCreated);

        //when
        when(customerRepo.save(any(CustomerEntity.class))).thenAnswer(invocation -> {
            ReflectionTestUtils.setField((CustomerEntity) invocation.getArgument(0), "id", expectedId);
            return entity;
        });

        CustomerResponseDTO responseDTO = serviceTest.createCustomer(customerRequest);


        // then
        ArgumentCaptor<CustomerEntity> customerCaptor =
                ArgumentCaptor.forClass(CustomerEntity.class);

        verify(customerRepo).save(customerCaptor.capture());

        assertThat(customerCaptor.getValue().getId()).isEqualTo(1L);
        assertThat(customerCaptor.getValue().getName()).isEqualTo("Tobi Ola");
        assertThat(customerCaptor.getValue().getEmail()).isEqualTo("tobi.ola@bank.com");
        assertThat(customerCaptor.getValue().getAddress()).isEqualTo("Lagos, Nigeria");
        assertThat(customerCaptor.getValue().getPhoneNumber()).isEqualTo("2341782345690");
        assertThat(customerCaptor.getValue().getDateOfBirth()).isEqualTo(dateOfBirth);


        assertThat(responseDTO.getId()).isEqualTo(1L);
        assertThat(responseDTO.getName()).isEqualTo("Tobi Ola");
        assertThat(responseDTO.getEmail()).isEqualTo("tobi.ola@bank.com");
        assertThat(responseDTO.getAddress()).isEqualTo("Lagos, Nigeria");
        assertThat(responseDTO.getPhoneNumber()).isEqualTo("2341782345690");
        assertThat(responseDTO.getDateOfBirth()).isEqualTo(dateOfBirth);

    }

    @Test
    @DisplayName("createCustomer should throw exception if customer email already exists")
    void shouldThrowExceptionIfCustomerEmailAlreadyExists() {
        //given

        CustomerRequestDTO customerRequest = new CustomerRequestDTO();
        customerRequest.setName( "Sly Black");
        customerRequest.setEmail("sly.black@bank.com");
        customerRequest.setPhoneNumber("3417456238290");
        customerRequest.setAddress("PH, Nigeria");
        customerRequest.setDateOfBirth(LocalDate.of(1981, 12, 05));

        given(customerRepo.existsByEmail(customerRequest.getEmail()))
                .willReturn(true);

        //when

        // then
        assertThatThrownBy(() -> serviceTest.createCustomer(customerRequest))
                .isInstanceOf(InvalidValueException.class)
                .hasMessageContaining("Customer Already Exists");

        verify(customerRepo, never()).save(any());

    }

    @Test
    @Disabled
    void updateCustomer() {
    }

    @Test
    @Disabled
    void findAllCustomers() {
    }

    @Test
    @Disabled
    void findCustomer() {
    }

    @Test
    @Disabled
    void deleteCustomer() {
    }
}