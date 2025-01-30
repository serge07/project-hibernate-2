package com.movie.repository;

import com.movie.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<Staff, Integer> {
    // Custom query methods can be added here if needed
}