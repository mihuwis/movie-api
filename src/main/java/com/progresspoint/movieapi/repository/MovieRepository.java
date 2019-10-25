package com.progresspoint.movieapi.repository;

import com.progresspoint.movieapi.model.Movie;
import org.springframework.data.repository.CrudRepository;


public interface MovieRepository extends CrudRepository<Movie, Long> {


}
