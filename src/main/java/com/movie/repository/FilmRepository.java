package com.movie.repository;

import com.movie.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Integer> {
    // Custom query methods can be added here if needed
}