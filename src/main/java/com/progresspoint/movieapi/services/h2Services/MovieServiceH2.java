package com.progresspoint.movieapi.services.h2Services;

import com.progresspoint.movieapi.model.Movie;
import com.progresspoint.movieapi.repository.MovieRepository;
import com.progresspoint.movieapi.services.MovieService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
public class MovieServiceH2 implements MovieService {

    private final MovieRepository movieRepository;

    public MovieServiceH2(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }


    @Override
    public Stream<Movie> findAll() {
        return StreamSupport.stream((movieRepository.findAll()).spliterator(), false);
    }

    @Override
    public Optional<Movie> findById(Long id) {
        return movieRepository.findById(id);
    }

    @Override
    public Stream<Movie> findAllByTitle(String title) {
        return movieRepository.getMoviesByTitleLike(title);
    }

    @Override
    public Stream<Movie> getAllByGenre(String genreName){
        return movieRepository.getMoviesByGenres(genreName);
    }

    @Override
    public Movie save(Movie object) {
        return movieRepository.save(object);
    }

    @Override
    public void delete(Movie object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

}
