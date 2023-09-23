package com.example.movie.repository.impl;

import com.example.movie.model.Movie;
import com.example.movie.repository.MovieRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class MovieInMemoryRepositoryImpl implements MovieRepository {
    private ArrayList<Movie> movies;

    public MovieInMemoryRepositoryImpl() {
        this.movies = new ArrayList<Movie>(Arrays.asList(Movie.builder().title("movie1").score(7).releaseYear("25.07.1994").id(1).build()));
    }

    @Override
    public List<Movie> Get() {
        return movies;
    }

    @Override // TODO: nasıl test yazarız?
    public Optional<Movie> Get(int id) {
        return movies.stream().filter(movie -> movie.getId() == id).findFirst();
    }

    @Override
    public void Post(Movie movie) {
        movies.add(movie);
    }

}
