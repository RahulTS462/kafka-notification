package com.eatit.notification.service;

import com.eatit.notification.event.OrderEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer {
    // A topic is a logical-named category or feed to which records are published.
    private static final String TOPIC = "food-orders";

    @Autowired
    private KafkaTemplate<String, OrderEvent> kafkaTemplate;

    public void placeOrder(OrderEvent orderEvent){
        //logic for order placement
        kafkaTemplate.send(TOPIC, orderEvent.getOrderId(), orderEvent);
    }
}
