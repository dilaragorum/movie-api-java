package com.example.movie.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class MovieDto {
    private int id;
    private String title;
    private String releaseYear;
    private float score;
    private String quote;

    public String toString() {
        return String.format("id: %d, title: %s, release year: %s, score: %f, quote: %s", id, title, releaseYear, score, quote);
    }
}
