package com.eatit.notification.service;

import com.eatit.notification.event.OrderEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService {

    @KafkaListener(topics = "food-orders", groupId = "delivery-group")
    public void consumeOrder(OrderEvent orderEvent){
        System.out.println("Assigning delivery partner for the order: "+orderEvent.getOrderId());
    }
}
