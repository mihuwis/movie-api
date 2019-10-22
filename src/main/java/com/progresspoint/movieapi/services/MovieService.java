package com.progresspoint.movieapi.services;

import com.progresspoint.movieapi.model.Movie;

public interface MovieService extends CrudService<Movie, Long>{

    Movie findByTitle(String title);
}
