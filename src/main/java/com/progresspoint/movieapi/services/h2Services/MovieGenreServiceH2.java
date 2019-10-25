package com.progresspoint.movieapi.services.h2Services;

import com.progresspoint.movieapi.model.MovieGenre;
import com.progresspoint.movieapi.repository.MovieGenreRepository;
import com.progresspoint.movieapi.services.MovieGenreService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
public class MovieGenreServiceH2 implements MovieGenreService {

    private final MovieGenreRepository movieGenreRepository;

    public MovieGenreServiceH2(MovieGenreRepository movieGenreRepository) {
        this.movieGenreRepository = movieGenreRepository;
    }

    @Override
    public Stream<MovieGenre> findAll() {
        return StreamSupport.stream(movieGenreRepository.findAll().spliterator(), false);
    }

    @Override
    public Optional<MovieGenre> findById(Long id) {
        return movieGenreRepository.findById(id);
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
