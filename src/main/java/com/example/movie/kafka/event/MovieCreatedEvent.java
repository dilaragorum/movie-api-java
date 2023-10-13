package com.example.movie.kafka.event;

import lombok.Builder;
import lombok.Data;

@Data
public class MovieCreatedEvent {
    private int id;
    private String title;
    private String releaseYear;
    private float score;
}
