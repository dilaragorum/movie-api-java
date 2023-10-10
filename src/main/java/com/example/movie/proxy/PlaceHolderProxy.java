package com.example.movie.proxy;

import com.example.movie.client.PlaceHolderClient;
import com.example.movie.client.model.response.PlaceHolderResponse;
import com.example.movie.exception.PlaceHolderException;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlaceHolderProxy {
    private final PlaceHolderClient placeHolderClient;

    public PlaceHolderResponse GetQuote(String id) {
        PlaceHolderResponse quote;
        try {
            quote = placeHolderClient.getQuote(id);
        } catch (Exception e) {
            throw new PlaceHolderException("Get error when getting quote from Json Place Holder");
        }

        if (quote == null) {
            throw new PlaceHolderException("Quote is empty after getting it from Json Place Holder");
        }

        return quote;
    }
}
