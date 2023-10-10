package com.example.movie;

import com.example.movie.client.model.response.PlaceHolderResponse;
import com.example.movie.proxy.PlaceHolderProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MovieApplication implements ApplicationRunner {
    @Autowired
    private PlaceHolderProxy placeHolderProxy;

    public static void main(String[] args) {
        SpringApplication.run(MovieApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        PlaceHolderResponse placeHolderResponse = placeHolderProxy.GetQuote("1");
        System.out.println(placeHolderResponse);


    }
}
