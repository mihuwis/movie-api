package com.progresspoint.movieapi.repository;

import com.progresspoint.movieapi.model.MovieGenre;
import org.springframework.data.repository.CrudRepository;

public interface MovieGenreRepository extends CrudRepository<MovieGenre, Long> {
}
