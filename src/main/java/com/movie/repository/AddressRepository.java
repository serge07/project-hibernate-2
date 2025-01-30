package com.movie.repository;

import com.movie.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
    // Custom query methods can be added here if needed
}