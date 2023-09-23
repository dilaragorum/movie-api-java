package com.example.movie.service;

import com.example.movie.model.Movie;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface MovieService {
    List<Movie> GetMovies();

    Optional<Movie> GetMovie(int id);

    void CreateMovie(Movie movie);
}
