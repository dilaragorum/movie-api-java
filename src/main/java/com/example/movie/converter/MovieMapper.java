package com.example.movie.converter;

import com.example.movie.kafka.event.MovieCreatedEvent;
import com.example.movie.model.Movie;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MovieMapper {
    MovieCreatedEvent mapToMovieCreatedEvent(Movie movie);
}
