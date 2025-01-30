package com.movie.repository;

import com.movie.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    // Custom query methods can be added here if needed
}