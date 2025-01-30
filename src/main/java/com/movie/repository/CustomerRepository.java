package com.movie.repository;

import com.movie.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    // Custom query methods can be added here if needed
}