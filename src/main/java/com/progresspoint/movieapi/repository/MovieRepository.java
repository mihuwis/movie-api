package com.progresspoint.movieapi.repository;

import com.progresspoint.movieapi.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.stream.Stream;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query("SELECT m FROM Movie m INNER JOIN m.genres g WHERE g.genreName = ?1")
    Stream<Movie> getMoviesByGenres(String genreName);

    Stream<Movie> getMoviesByTitleLike(String title);
}
