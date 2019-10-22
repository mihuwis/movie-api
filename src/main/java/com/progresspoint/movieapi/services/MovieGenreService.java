package com.progresspoint.movieapi.services;

import com.progresspoint.movieapi.model.MovieGenre;

public interface MovieGenreService extends CrudService<MovieGenre, Long> {

    MovieGenre findByMovieGenreName(String movieGenreName);
}
