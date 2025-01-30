package com.movie.repository;

import com.movie.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language, Integer> {
    // Custom query methods can be added here if needed
}