package com.bank.api.service.inf;

import com.bank.api.pojos.CustomerRequestDTO;
import com.bank.api.pojos.CustomerResponseDTO;
import com.bank.api.pojos.CustomerUpdateRequestDTO;

import java.util.List;

public interface CustomerServiceInf {

    /**
     * Create a new Customer
     * @param customerRequestDTO Customer Request Data
     * @return Customer New record
     */
    CustomerResponseDTO createCustomer(CustomerRequestDTO customerRequestDTO);

    /**
     * Update a Customer's record
     * @param updateRequestDTO Customer Update Request Data
     * @return Customer Updated Record
     */
    CustomerResponseDTO updateCustomer(CustomerUpdateRequestDTO updateRequestDTO);

    /**
     * Get all Customers
     * @return List of All Customers
     */
    List<CustomerResponseDTO> findAllCustomers();

    /**
     * Get a particular Customer's record
     * @param id unique Customer ID
     * @return Customer records
     */
    CustomerResponseDTO findCustomer(Long id);

    /**
     * Delete a Customer's record
     * @param id
     */
    void deleteCustomer(Long id);
}