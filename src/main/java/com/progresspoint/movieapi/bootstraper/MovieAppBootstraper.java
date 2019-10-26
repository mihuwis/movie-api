package com.progresspoint.movieapi.bootstraper;

import com.progresspoint.movieapi.model.Movie;
import com.progresspoint.movieapi.model.MovieGenre;
import com.progresspoint.movieapi.services.MovieGenreService;
import com.progresspoint.movieapi.services.MovieService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;

@Component
public class MovieAppBootstraper implements CommandLineRunner {

    private final MovieService movieService;
    private final MovieGenreService movieGenreService;

    public MovieAppBootstraper(MovieService movieService, MovieGenreService movieGenreService) {
        this.movieService = movieService;
        this.movieGenreService = movieGenreService;
    }

    @Override
    public void run(String... args) throws Exception {
        loadData();
    }

    private void loadData() {
        MovieGenre actionMovie = new MovieGenre("action");
        movieGenreService.save(actionMovie);
        MovieGenre animationMovie = new MovieGenre("animation");
        movieGenreService.save(animationMovie);
        MovieGenre comedyMovie = new MovieGenre("comedy");
        movieGenreService.save(comedyMovie);
        MovieGenre horrorMovie = new MovieGenre("horror");
        movieGenreService.save(horrorMovie);
        MovieGenre romanceMovie = new MovieGenre("romance");
        movieGenreService.save(romanceMovie);
        MovieGenre dramaMovie = new MovieGenre("drama");
        movieGenreService.save(dramaMovie);

        Movie movie01 = new Movie("Titanic", "1990", "WB",
                new HashSet<>(Arrays.asList(actionMovie, romanceMovie)));
        movieService.save(movie01);

        Movie movie02 = new Movie("Exorcist", "1998", "Walt Disney",
                new HashSet<>(Arrays.asList(actionMovie, horrorMovie)));
        movieService.save(movie02);

        Movie movie03 = new Movie("Rambo", "2001", "ZR",
                new HashSet<>(Arrays.asList(actionMovie)));
        movieService.save(movie03);

        Movie movie04 = new Movie("Ben Hur", "1976", "GM",
                new HashSet<>(Arrays.asList(actionMovie, comedyMovie)));
        movieService.save(movie04);

        Movie movie05 = new Movie("Pretty Woman", "1987", "DB",
                new HashSet<>(Arrays.asList(romanceMovie, comedyMovie)));
        movieService.save(movie05);

        Movie movie06 = new Movie("Toy story", "2001", "Pixar",
                new HashSet<>(Arrays.asList(animationMovie, comedyMovie, actionMovie)));
        movieService.save(movie06);

        Movie movie07 = new Movie("Titanic", "1945", "Semafor",
                new HashSet<>(Arrays.asList(actionMovie, romanceMovie)));
        movieService.save(movie07);

        Movie movie08 = new Movie("Toy story 2", "2010", "Pixar",
                new HashSet<>(Arrays.asList(animationMovie, comedyMovie, actionMovie)));
        movieService.save(movie08);

        Movie movie09 = new Movie("Toy story 3", "2014", "Pixar",
                new HashSet<>(Arrays.asList(animationMovie, comedyMovie, actionMovie)));
        movieService.save(movie09);

        Movie movie10 = new Movie("Toy soldier", "2003", "DB",
                new HashSet<>(Arrays.asList(dramaMovie, romanceMovie)));
        movieService.save(movie10);
    }


}
