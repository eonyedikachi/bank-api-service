package com.bank.api.service.impl;

import com.bank.api.entities.CustomerEntity;
import com.bank.api.pojos.CustomerRequestDTO;
import com.bank.api.pojos.CustomerResponseDTO;
import com.bank.api.repos.CustomerRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.any;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {

    @Mock
    private CustomerRepository customerRepo;

    @InjectMocks
    private CustomerServiceImpl serviceTest;

    @Test
    void createCustomer() {
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
        entity.setId(1L);
        entity.setName( "Tobi Ola");
        entity.setEmail("tobi.ola@bank.com");
        entity.setPhoneNumber("2341782345690");
        entity.setAddress("Lagos, Nigeria");
        entity.setDateOfBirth(dateOfBirth);
        entity.setDateCreated(dateCreated);

        //when
        when(customerRepo.save(any(CustomerEntity.class))).thenReturn(entity);

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
        assertThat(customerCaptor.getValue().getDateOfBirth()).isEqualTo(dateCreated);
        assertThat(customerCaptor.getValue().getDateCreated()).isEqualTo(dateCreated);


        assertThat(responseDTO.getId()).isEqualTo(1L);
        assertThat(responseDTO.getName()).isEqualTo("Tobi Ola");
        assertThat(responseDTO.getEmail()).isEqualTo("tobi.ola@bank.com");
        assertThat(responseDTO.getAddress()).isEqualTo("Lagos, Nigeria");
        assertThat(responseDTO.getPhoneNumber()).isEqualTo("2341782345690");
        assertThat(responseDTO.getDateOfBirth()).isEqualTo(dateCreated);
        assertThat(responseDTO.getDateCreated()).isEqualTo(dateCreated);
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