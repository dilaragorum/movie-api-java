package com.example.movie.proxy;

import com.example.movie.client.model.response.PlaceHolderResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class PlaceHolderProxyTest {
    //nesne oluşturup veriyor. --> mocklayabiliyorsun/ ister gerçek obje
    @Autowired
    private PlaceHolderProxy placeHolderProxy;

    @Test
    void callProxy() {
        PlaceHolderResponse quote = placeHolderProxy.GetQuote("1");
        System.out.println(quote);

        //PlaceHolderResponse placeHolderResponse = placeHolderProxy.GetQuote("1");
        //System.out.println(placeHolderResponse);
    }


}