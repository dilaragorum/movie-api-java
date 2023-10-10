package com.example.movie.client.model.response;

import com.example.movie.model.MovieDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class PlaceHolderResponse {
    private int userId;
    private int id;
    private String title;
    private String body;

    public String toString() {
        return String.format("userId: %d, id: %d, title: %s, body: %s", userId, id, title, body);
    }
}
