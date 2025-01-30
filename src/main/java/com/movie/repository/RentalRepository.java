package com.movie.repository;

import com.movie.entity.Inventory;
import com.movie.entity.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental, Integer> {
    // Find the latest rental for a given inventory
    Rental findTopByInventoryOrderByRentalDateDesc(Inventory inventory);
}