package com.example.movie.converter;

import com.example.movie.kafka.event.MovieCreatedEvent;
import com.example.movie.model.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MovieMapper {
    MovieMapper MAPPER = Mappers.getMapper(MovieMapper.class);

    MovieCreatedEvent mapToMovieCreatedEvent(Movie movie);
}
