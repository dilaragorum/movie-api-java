package com.example.movie.service.impl;

import com.example.movie.converter.MovieMapper;
import com.example.movie.exception.NotFoundException;
import com.example.movie.kafka.event.MovieCreatedEvent;
import com.example.movie.kafka.message.KafkaMessage;
import com.example.movie.kafka.producer.MovieEventProducer;
import com.example.movie.model.Movie;
import com.example.movie.model.MovieDto;
import com.example.movie.proxy.PlaceHolderProxy;
import com.example.movie.repository.MovieRepository;
import com.example.movie.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;

    private final PlaceHolderProxy placeHolderProxy;

    private final MovieEventProducer movieEventProducer;

    @Value("${topic.name.producer}")
    private String topicName;

    @Override
    public List<Movie> GetMovies() {
        return movieRepository.Get();
    }

    @Override
    public Optional<MovieDto> GetMovie(int id) throws NotFoundException {
        Optional<Movie> optMovie = Optional.of(movieRepository.Get(id).orElseThrow(() -> new NotFoundException("movie not found")));

        Movie movie = optMovie.get();

        String quote = placeHolderProxy.GetQuote(String.valueOf(id)).getBody();


        MovieDto movieDTO = movie.toDto(quote);

        return Optional.of(movieDTO);
    }

    @Override
    public void CreateMovie(Movie movie) {
        movieRepository.Post(movie);
        MovieCreatedEvent movieCreatedEvent = MovieMapper.MAPPER.mapToMovieCreatedEvent(movie);
        KafkaMessage<MovieCreatedEvent> createdEvent = KafkaMessage.<MovieCreatedEvent>builder().topic(topicName).body(movieCreatedEvent).build();
        movieEventProducer.send(createdEvent);
    }
}
