package com.example.movie.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Movie {
    private int id;
    private String title;
    private String releaseYear;
    private float score;
}
