package com.hdbank.bankingeventhandler.service;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.hdbank.bankingeventhandler.handler.EventHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class EventConsumerImpl implements EventConsumer {

    // nhớ đặt tên cho các bean handler giống với tên type của event
    private final Map<String, EventHandler> factories;

    @Override
    @KafkaListener(topics = "banking")
    public void process(String payload) {
        // Xử lý sự kiện ở đây

        try {
            log.info("Received message: {}", payload);
            JsonObject json = JsonParser.parseString(payload).getAsJsonObject();
            String type = json.get("eventType")
                    .getAsString();
            log.info("Type: {}", type);
            factories.get(type)
                    .handle(
                            json
                    );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @KafkaListener(topics = "TRANSACTION_SUCCESS")
    public void handleTransaction(String message) {
        System.out.println( "Message: "+ message);

    }

    @KafkaListener(topics = "UPDATE_SUCCESS")
    public void handleUpdate(String message) {
        System.out.println( "Message: "+ message);

    }
    @KafkaListener(topics = "CREATE_SUCCESS")
    public void handleCreate(String message) {
        System.out.println( "Message: "+ message);

    }
}
