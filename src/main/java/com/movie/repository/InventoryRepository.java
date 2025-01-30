package com.movie.repository;

import com.movie.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
    // Custom query methods can be added here if needed
}