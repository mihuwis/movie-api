package com.progresspoint.movieapi.services;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

public interface CrudService<T, ID> {

    Stream<T> findAll();

    Optional<T> findById(ID id);

    void delete(T object);

    void deleteById(ID id);

    T save(T object);
}
