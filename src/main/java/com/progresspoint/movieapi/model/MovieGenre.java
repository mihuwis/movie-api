package com.progresspoint.movieapi.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class MovieGenre {

    @Id
    @Column(name = "genre_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long genreId;

    @Column(name = "genre_name")
    private String genreName;

    @ManyToMany(mappedBy = "genres")
    private Set<Movie> movies = new HashSet<>();

    public MovieGenre(String genreName, Set<Movie> movies) {
        this.genreName = genreName;
        this.movies = movies;
    }

    public MovieGenre(String genreName) {
        this.genreName = genreName;
    }

    public MovieGenre() {
    }

    public Long getGenreId() {
        return genreId;
    }

    public void setGenreId(Long genreId) {
        this.genreId = genreId;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }
}
