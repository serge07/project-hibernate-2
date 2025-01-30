package com.movie.repository;

import com.movie.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Integer> {
    // Custom query methods can be added here if needed
}