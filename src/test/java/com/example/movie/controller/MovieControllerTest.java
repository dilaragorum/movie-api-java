package com.example.movie.controller;

import com.example.movie.model.Movie;
import com.example.movie.service.MovieService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(controllers = MovieController.class)
@ExtendWith(MockitoExtension.class)
public class MovieControllerTest {

    @MockBean
    private MovieService movieService;

    @Autowired
    private MockMvc mockMvc;

    private static final String BASE_URL = "/api/movies";

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void get_movie_successfully() throws Exception {
        // Given
        Movie movie1 = Movie.builder().title("test").score(10).id(1).releaseYear("25/07/1994").build();
        Movie movie2 = Movie.builder().title("test").score(10).id(1).releaseYear("25/07/1994").build();

        List<Movie> movies = Arrays.asList(movie1, movie2);

        // When
        ResultActions test = mockMvc.perform(get(BASE_URL)
                .content(objectMapper.writeValueAsString(movies))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

        // Then
        verify(movieService).GetMovies();
        test.andExpect(status().isOk());
    }

    @Test
    void get_movies_successfully() throws Exception {
        // Given
        String url = BASE_URL + "/1";

        // When
        ResultActions test = mockMvc.perform(get(url).contentType(MediaType.APPLICATION_JSON).
                content(Movie.builder().title("test").score(10).id(1).releaseYear("25/07/1994").toString())).andExpect(status().isOk());

        // Then
        verify(movieService).GetMovie(1);
        test.andExpect(status().isOk());
    }

    @Test
    void create_movie_successfully() throws Exception {
        // Given
        Movie movie = Movie.builder().title("test").score(10).id(1).releaseYear("25/07/1994").build();

        // When
        ResultActions test = mockMvc.perform(post(BASE_URL).contentType(MediaType.APPLICATION_JSON).
                content(objectMapper.writeValueAsString(movie))).andExpect(status().isCreated());

        // Then
        verify(movieService).CreateMovie(movie);
        test.andExpect(status().isCreated());
    }
}