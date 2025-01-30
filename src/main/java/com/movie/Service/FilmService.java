package com.movie.Service;

import com.movie.entity.*;
import com.movie.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Service
public class FilmService {
    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private FilmActorRepository filmActorRepository;

    @Autowired
    private FilmCategoryRepository filmCategoryRepository;

    @Autowired
    private ActorRepository actorRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private LanguageRepository languageRepository;

    @Transactional
    public void addNewFilm(Film film, Language language, Language originalLanguage, List<Actor> actors, List<Category> categories) {
        // Set the language and original language for the film
        film.setLanguage(language);
        film.setOriginalLanguage(originalLanguage);
        film.setLastUpdate(new Timestamp(System.currentTimeMillis()));

        // Save the film
        filmRepository.save(film);

        // Link actors to the film
        for (Actor actor : actors) {
            FilmActor filmActor = new FilmActor();
            filmActor.setFilm(film);
            filmActor.setActor(actor);
            filmActor.setLastUpdate(new Timestamp(System.currentTimeMillis()));
            filmActorRepository.save(filmActor);
        }

        // Link categories to the film
        for (Category category : categories) {
            FilmCategory filmCategory = new FilmCategory();
            filmCategory.setFilm(film);
            filmCategory.setCategory(category);
            filmCategory.setLastUpdate(new Timestamp(System.currentTimeMillis()));
            filmCategoryRepository.save(filmCategory);
        }
    }
}