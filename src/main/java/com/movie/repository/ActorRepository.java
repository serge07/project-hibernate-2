package com.movie.repository;

import com.movie.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Integer> {
    // Custom query methods can be added here if needed
}