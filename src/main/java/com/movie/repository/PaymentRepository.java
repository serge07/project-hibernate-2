package com.movie.repository;

import com.movie.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    // Custom query methods can be added here if needed
}