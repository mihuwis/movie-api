package com.progresspoint.movieapi.controller;

import com.progresspoint.movieapi.model.Movie;
import com.progresspoint.movieapi.services.MovieService;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


@RestController
@RequestMapping("api/v1/movie")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }


    @GetMapping
    public ResponseEntity<Resources<Resource<Movie>>> getAll(){
        Resources<Resource<Movie>> resources = new Resources<>(
                movieService.findAll()
                .map(this::createResource)
                .collect(Collectors.toList())
        );
        resources.add(linkTo(methodOn(MovieController.class).getAll()).withSelfRel());

        return ResponseEntity.ok().body(resources);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Resource<Movie>> getById(@PathVariable Long id){
        return movieService.findById(id)
                .map(this::createResource)
                .map(resource -> ResponseEntity.ok().body(resource))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/genre/{genre}")
    public ResponseEntity<Resources<Resource<Movie>>> getByGenre(@PathVariable String genre){
        Resources<Resource<Movie>> resources = new Resources<>(
                movieService.getAllByGenre(genre)
                .map(this::createResource)
                .collect(Collectors.toList())
        );
        return ResponseEntity.ok().body(resources);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Resource<Movie>> getByTitle(@PathVariable String name){
        return movieService.findByName(name)
                .map(this::createResource)
                .map(movieResource -> ResponseEntity.ok().body(movieResource))
                .orElse(ResponseEntity.notFound().build());
    }


    private Resource<Movie> createResource(Movie movie){
        Resource<Movie> resource = new Resource<>(movie);
        resource.add(linkTo(methodOn(MovieController.class).getById(movie.getId())).withSelfRel());
        return resource;
    }





}
