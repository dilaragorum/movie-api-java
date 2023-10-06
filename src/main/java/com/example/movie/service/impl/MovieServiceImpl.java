package com.example.movie.service.impl;

import com.example.movie.exception.NotFoundException;
import com.example.movie.model.Movie;
import com.example.movie.repository.MovieRepository;
import com.example.movie.service.MovieService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Service
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;

    @Override
    public List<Movie> GetMovies() {
        return movieRepository.Get();
    }

    @Override
    public Optional<Movie> GetMovie(int id) throws NotFoundException {
        return Optional.of(movieRepository.Get(id).orElseThrow(()-> new NotFoundException("movie not found")));
    }

    @Override
    public void CreateMovie(Movie movie) {
        movieRepository.Post(movie);
    }
}
