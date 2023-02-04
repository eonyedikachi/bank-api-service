package com.bank.api.repos;

import com.bank.api.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

    boolean existsByEmail (String email);

}
