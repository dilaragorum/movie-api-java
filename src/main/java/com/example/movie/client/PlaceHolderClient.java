package com.example.movie.client;

import com.example.movie.client.model.response.PlaceHolderResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// Proxy'de bir servis gibi tanımlamak için FeignClient kullanabiliriz.

@Service
@FeignClient(value ="place-holder", url ="https://jsonplaceholder.typicode.com/posts/")
public interface PlaceHolderClient {
    @GetMapping("/{id}")
    PlaceHolderResponse getQuote(@PathVariable("id") String id);
}
