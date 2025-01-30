package com.movie.repository;

import com.movie.entity.FilmCategory;
import com.movie.entity.FilmCategoryId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmCategoryRepository extends JpaRepository<FilmCategory, FilmCategoryId> {
    // Custom query methods can be added here if needed
}