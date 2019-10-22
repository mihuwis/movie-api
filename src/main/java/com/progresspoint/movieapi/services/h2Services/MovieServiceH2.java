package com.progresspoint.movieapi.services.h2Services;

import com.progresspoint.movieapi.model.Movie;
import com.progresspoint.movieapi.repository.MovieRepository;
import com.progresspoint.movieapi.services.MovieService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
public class MovieServiceH2 implements MovieService {

    private final MovieRepository movieRepository;

    public MovieServiceH2(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }


    @Override
    public Movie findByTitle(String title) {
        return null;
    }

    @Override
    public Stream<Movie> findAll() {
        return StreamSupport.stream((movieRepository.findAll()).spliterator(), false);
    }

    @Override
    public Optional<Movie> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public void delete(Movie object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public Movie save(Movie object) {
        return movieRepository.save(object);
    }
}
