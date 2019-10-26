package com.progresspoint.movieapi.repository;

import com.progresspoint.movieapi.model.MovieGenre;
import org.springframework.data.repository.CrudRepository;

import java.util.stream.Stream;

public interface MovieGenreRepository extends CrudRepository<MovieGenre, Long> {

    Stream<MovieGenre> findByGenreNameLike(String genreName);
}
