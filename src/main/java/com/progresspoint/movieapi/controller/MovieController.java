package com.progresspoint.movieapi.controller;

import com.progresspoint.movieapi.model.Movie;
import com.progresspoint.movieapi.services.MovieService;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping(value = "api/v1/movie", produces = MediaType.APPLICATION_JSON_VALUE)
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<Resources<Resource<Movie>>> getAll() {
        Resources<Resource<Movie>> resources = new Resources<>(
                movieService.findAll()
                        .map(this::createResource)
                        .collect(Collectors.toList())
        );
        resources.add(linkTo(methodOn(MovieController.class).getAll()).withSelfRel());
        return ResponseEntity.ok().body(resources);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Resource<Movie>> getById(@PathVariable Long id) {
        return movieService.findById(id)
                .map(this::createResource)
                .map(resource -> ResponseEntity.ok().body(resource))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/genre/{genre}")
    @Transactional
    public ResponseEntity<Resources<Resource<Movie>>> getByGenre(@PathVariable String genre) {
        Resources<Resource<Movie>> resources = new Resources<>(
                movieService.getAllByGenre(genre)
                        .map(this::createResource)
                        .collect(Collectors.toList())
        );
        //TODO add links
        return ResponseEntity.ok().body(resources);
    }

    @GetMapping("/title/{title}")
    @Transactional
    public ResponseEntity<Resources<Resource<Movie>>> getByTitle(@PathVariable String title) {
        Resources<Resource<Movie>> resources = new Resources<>(
                movieService.findAllByTitle(title)
                        .map(this::createResource)
                        .collect(Collectors.toList())
        );
        // TODO add links
        return ResponseEntity.ok().body(resources);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> addNewMovie(@RequestBody Movie newMovie) {
        Movie addedMovie = movieService.save(newMovie);
        return ResponseEntity
                .created(URI.create(createResource(addedMovie).getLink("self").getHref()))
                .build();
    }


    private Resource<Movie> createResource(Movie movie) {
        Resource<Movie> resource = new Resource<>(movie);
        resource.add(linkTo(methodOn(MovieController.class).getById(movie.getId())).withSelfRel());
        return resource;
    }


}
