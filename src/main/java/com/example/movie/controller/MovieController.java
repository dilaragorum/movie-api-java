package com.example.movie.controller;


import com.example.movie.model.Movie;
import com.example.movie.service.MovieService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/movies")
@RequiredArgsConstructor
@RestController
@Slf4j
public class MovieController {
    private final MovieService movieService;

    // TODO: hata durumunda ResponseStatus'u nasıl yönetiyoruz, öğrenelim!
    @GetMapping()
    public List<Movie> getAll() {
        log.info("get movies endpoint'ine istek atılıyor");
        return movieService.GetMovies();
    }


    @GetMapping("{id}")
    public Optional<Movie> getWithId(@PathVariable int id) {
        log.info("get movies{id} endpoint'ine istek atılıyor");
        return movieService.GetMovie(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public void createMovie(@RequestBody Movie movie) {
        log.info("post movies endpoint'ine istek atılıyor");
        movieService.CreateMovie(movie);
    }
}
