package com.movie.repository;

import com.movie.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Integer> {
    // Custom query methods can be added here if needed
}