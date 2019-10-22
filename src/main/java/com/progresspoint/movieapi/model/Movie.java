package com.progresspoint.movieapi.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Movie {

    @Id
    @Column(name = "movie_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "movie_title")
    private String title;

    @Column(name = "production_year")
    private String year;

    @Column(name = "producer_name")
    private String producer;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "movie_movie_genre",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_genre_id"))
    private Set<MovieGenre> genres = new HashSet<>();

    public Movie(String title, String year, String producer, Set<MovieGenre> genres) {
        this.title = title;
        this.year = year;
        this.producer = producer;
        this.genres = genres;
    }

    public Movie() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public Set<MovieGenre> getGenres() {
        return genres;
    }

    public void setGenres(Set<MovieGenre> genres) {
        this.genres = genres;
    }
}
