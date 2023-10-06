package com.example.movie.service.impl;

import com.example.movie.exception.NotFoundException;
import com.example.movie.model.Movie;
import com.example.movie.repository.MovieRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MovieServiceImplTest {
    @InjectMocks
    private MovieServiceImpl _sut;

    @Mock
    private MovieRepository movieRepository;

    private Movie movie;

    private List<Movie> movies;

    @BeforeEach
    void setUp() {
        movie = Movie.builder().releaseYear("25/07/1994").id(1).score(30).title("exampleMovie").build();
        movies = Arrays.asList(
                Movie.builder().releaseYear("25/07/1994").id(1).score(30).title("exampleMovie").build(),
                Movie.builder().releaseYear("06/01/2023").id(2).score(60).title("exampleMovie2").build()
        );
    }

    @Test
    void it_should_throw_exception_when_movie_cannot_be_found() {
        // given
        doThrow(NotFoundException.class).when(movieRepository).Get(anyInt());

        // when

        // then
        Assertions.assertThrows(NotFoundException.class, () -> _sut.GetMovie(1));
        verify(movieRepository).Get(anyInt());
    }

    @Test
    void it_should_return_movie_successfully_when_movie_can_be_found() {
        // given
        when(movieRepository.Get(anyInt())).thenReturn(Optional.ofNullable(movie));

        // when
        Optional<Movie> expectedResponse = _sut.GetMovie(1);

        // then
        verify(movieRepository).Get(anyInt());
        assertEquals(expectedResponse, Optional.ofNullable(movie));
    }

    @Test
    void it_should_return_movies_successfully() {
        // given
        when(movieRepository.Get()).thenReturn(movies);

        // when
        List<Movie> expectedResponse = _sut.GetMovies();

        // then
        verify(movieRepository).Get();
        assertEquals(expectedResponse, movies);
    }

    @Test
    void it_should_create_movie_successfully() {
        // given
        doNothing().when(movieRepository).Post(movie);

        // when
        _sut.CreateMovie(movie);

        // then
        verify(movieRepository).Post(any());
    }
}