package com.bank.api.service.impl;

import com.bank.api.exceptions.InvalidValueException;
import com.bank.api.pojos.CustomerRequestDTO;
import com.bank.api.pojos.CustomerResponseDTO;
import com.bank.api.pojos.CustomerUpdateRequestDTO;
import com.bank.api.entities.CustomerEntity;
import com.bank.api.repos.CustomerRepository;
import com.bank.api.service.inf.CustomerServiceInf;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerServiceInf {

    @Autowired
    private CustomerRepository customerRepository;

    /**
     * Create a new Customer
     *
     * @param customerRequestDTO Customer Request Data
     * @return Customer New record
     */
    @Override
    public CustomerResponseDTO createCustomer(CustomerRequestDTO customerRequestDTO) {
        log.info("About to create new customer record");

        boolean exists = customerRepository.existsByEmail(customerRequestDTO.getEmail());

        if (exists)
            throw new InvalidValueException("Customer already exists");

        CustomerEntity customerEntity = mapToEntity(customerRequestDTO);
        customerEntity.setDateCreated(LocalDateTime.now());
        customerRepository.save(customerEntity);
        log.info("Successfully created new customer record");

        return mapToDTO(customerEntity);
    }

    /**
     * Update a Customer's record
     *
     * @param updateRequestDTO Customer Update Request Data
     * @return Customer Updated Record
     */
    @Override
    public CustomerResponseDTO updateCustomer(CustomerUpdateRequestDTO updateRequestDTO) {
        return null;
    }

    /**
     * Get all Customers
     *
     * @return List of All Customers
     */
    @Override
    public List<CustomerResponseDTO> findAllCustomers() {
        return null;
    }

    /**
     * Get a particular Customer's record
     *
     * @param id unique Customer ID
     * @return Customer records
     */
    @Override
    public CustomerResponseDTO findCustomer(Long id) {
        return null;
    }

    /**
     * Delete a Customer's record
     *
     * @param id
     */
    @Override
    public void deleteCustomer(Long id) {

    }

    private CustomerResponseDTO mapToDTO(CustomerEntity entity){

        CustomerResponseDTO  responseDTO= new CustomerResponseDTO();
        responseDTO.setId(entity.getId());
        responseDTO.setName(entity.getName());
        responseDTO.setEmail(entity.getEmail());
        responseDTO.setAddress(entity.getAddress());
        responseDTO.setPhoneNumber(entity.getPhoneNumber());
        responseDTO.setDateOfBirth(entity.getDateOfBirth());
        responseDTO.setDateCreated(entity.getDateCreated());
        responseDTO.setLastUpdated(entity.getLastUpdated());

        return responseDTO;
    }

    private CustomerEntity mapToEntity(CustomerRequestDTO requestDTO) {

        CustomerEntity customerEntity = new CustomerEntity();

        customerEntity.setName(requestDTO.getName());
        customerEntity.setEmail(requestDTO.getEmail());
        customerEntity.setPhoneNumber(requestDTO.getPhoneNumber());
        customerEntity.setAddress(requestDTO.getAddress());
        customerEntity.setDateOfBirth(requestDTO.getDateOfBirth());

        return customerEntity;
    }
}
