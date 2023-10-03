package com.example.movie.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Movie {
    private int id;
    private String title;
    private String releaseYear;
    private float score;

    public String toString() {
        return "id: " + id + " title: " + title + " releaseYear: " + releaseYear + " score: "+ score;
    }
}
