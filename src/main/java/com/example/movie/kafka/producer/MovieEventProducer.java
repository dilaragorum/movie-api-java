package com.example.movie.kafka.producer;

import com.example.movie.kafka.message.KafkaMessage;
import com.example.movie.utility.JsonConverter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MovieEventProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public <T> void send(KafkaMessage <T> kafkaMessage){
        String message = JsonConverter.objectToJson(kafkaMessage.getBody());
        kafkaTemplate.send(kafkaMessage.getTopic(), message);
    }
}
