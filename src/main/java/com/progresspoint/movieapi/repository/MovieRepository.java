package com.progresspoint.movieapi.repository;

import com.progresspoint.movieapi.model.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.stream.Stream;

public interface MovieRepository extends CrudRepository<Movie, Long> {

    Stream<Movie> getMoviesByGenresIsLike(String genreName);


    @Query(value = "SELECT * FROM Movie  WHERE name = ?1", nativeQuery = true)
    Optional<Movie> getMoviesByGenres(@Param("name") String name);
}
