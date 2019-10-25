package com.progresspoint.movieapi.controller;

import com.progresspoint.movieapi.model.Movie;
import com.progresspoint.movieapi.model.MovieGenre;
import com.progresspoint.movieapi.services.MovieGenreService;
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

@RequestMapping("api/v1/moviegenre")
@RestController
public class MovieGenreController {

    private final MovieGenreService movieGenreService;

    public MovieGenreController(MovieGenreService movieGenreService) {
        this.movieGenreService = movieGenreService;
    }

    @GetMapping
    public ResponseEntity<Resources<Resource<MovieGenre>>> getAll(){
        Resources<Resource<MovieGenre>> resources = new Resources<>(
                movieGenreService.findAll()
                .map(this::createResource)
                .collect(Collectors.toList())
        );
        resources.add(linkTo(methodOn(MovieGenreController.class).getAll()).withSelfRel());
        return ResponseEntity.ok().body(resources);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Resource<MovieGenre>> getById(@PathVariable Long id){
        return movieGenreService.findById(id)
                .map(this::createResource)
                .map(resource -> ResponseEntity.ok().body(resource))
                .orElse(ResponseEntity.notFound().build());
    }



    private Resource<MovieGenre> createResource(MovieGenre movieGenre){
        Resource<MovieGenre> resource = new Resource<>(movieGenre);
        resource.add(linkTo(methodOn(MovieGenreController.class).getById(movieGenre.getGenreId())).withSelfRel());
        return resource;
    }

}
