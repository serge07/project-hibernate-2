package com.movie.repository;

import com.movie.entity.FilmActor;
import com.movie.entity.FilmActorId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmActorRepository extends JpaRepository<FilmActor, FilmActorId> {
    // Custom query methods can be added here if needed
}