package com.example.movie.converter;

import com.example.movie.kafka.event.MovieCreatedEvent;
import com.example.movie.model.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MovieMapper {
    MovieCreatedEvent mapToMovieCreatedEvent(Movie movie);
}
