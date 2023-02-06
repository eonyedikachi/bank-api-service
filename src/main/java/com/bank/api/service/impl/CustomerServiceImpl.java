package com.bank.api.service.impl;

import com.bank.api.pojos.CustomerRequestDTO;
import com.bank.api.pojos.CustomerResponseDTO;
import com.bank.api.pojos.CustomerUpdateRequestDTO;
import com.bank.api.service.inf.CustomerServiceInf;

import java.util.List;

public class CustomerServiceImpl implements CustomerServiceInf {
    /**
     * Create a new Customer
     *
     * @param customerRequestDTO Customer Request Data
     * @return Customer New record
     */
    @Override
    public CustomerResponseDTO createCustomer(CustomerRequestDTO customerRequestDTO) {
        return null;
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
}
