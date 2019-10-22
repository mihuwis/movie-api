package com.progresspoint.movieapi.services.h2Services;

import com.progresspoint.movieapi.model.MovieGenre;
import com.progresspoint.movieapi.repository.MovieGenreRepository;
import com.progresspoint.movieapi.services.MovieGenreService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Stream;

@Service
public class MovieGenreServiceH2 implements MovieGenreService {

    private final MovieGenreRepository movieGenreRepository;

    public MovieGenreServiceH2(MovieGenreRepository movieGenreRepository) {
        this.movieGenreRepository = movieGenreRepository;
    }

    @Override
    public MovieGenre findByMovieGenreName(String movieGenreName) {
        return null;
    }

    @Override
    public Stream<MovieGenre> findAll() {
        return null;
    }

    @Override
    public Optional<MovieGenre> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public void delete(MovieGenre object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public MovieGenre save(MovieGenre object) {
        return movieGenreRepository.save(object);
    }
}
