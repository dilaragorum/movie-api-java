package com.example.movie.service.impl;

import com.example.movie.exception.NotFoundException;
import com.example.movie.model.Movie;
import com.example.movie.model.MovieDto;
import com.example.movie.proxy.PlaceHolderProxy;
import com.example.movie.repository.MovieRepository;
import com.example.movie.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Service
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;

    private final PlaceHolderProxy placeHolderProxy;

    @Override
    public List<Movie> GetMovies() {
        return movieRepository.Get();
    }

    @Override
    public Optional<MovieDto> GetMovie(int id) throws NotFoundException {
        Optional<Movie> optMovie = Optional.of(movieRepository.Get(id).orElseThrow(()-> new NotFoundException("movie not found")));

        Movie movie = optMovie.get();

        String quote = placeHolderProxy.GetQuote(String.valueOf(id)).getBody();



        MovieDto movieDTO = movie.toDto(quote);

        return Optional.of(movieDTO);
    }

    @Override
    public void CreateMovie(Movie movie) {
        movieRepository.Post(movie);
    }
}
