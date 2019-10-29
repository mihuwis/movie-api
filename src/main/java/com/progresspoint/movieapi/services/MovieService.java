package com.progresspoint.movieapi.services;

import com.progresspoint.movieapi.model.Movie;

import java.util.Optional;
import java.util.stream.Stream;

public interface MovieService extends CrudService<Movie, Long>{

    Stream<Movie> findAllByTitle(String name);
    Stream<Movie> getAllByGenre(String genreName);
}
