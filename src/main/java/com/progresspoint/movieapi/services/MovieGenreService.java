package com.progresspoint.movieapi.services;

import com.progresspoint.movieapi.model.MovieGenre;

import java.util.stream.Stream;

public interface MovieGenreService extends CrudService<MovieGenre, Long> {

    Stream<MovieGenre> findByMovieGenreName(String genreName);
}
