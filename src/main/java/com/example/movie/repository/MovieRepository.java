package com.example.movie.repository;

import com.example.movie.model.Movie;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface MovieRepository {
    List<Movie> Get();

    Optional<Movie> Get(int id);

    void Post(Movie movie);
}
