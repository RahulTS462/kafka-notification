package com.eatit.notification.controller;

import com.eatit.notification.event.OrderEvent;
import com.eatit.notification.service.OrderProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderProducer producer;

    @PostMapping
    public String createOrder(@RequestBody OrderEvent event) {
        // Accepts the HTTP request and triggers the producer to write the data to the Kafka ecosystem[cite: 4].
        producer.placeOrder(event);
        return "Order placed successfully! Bill: ₹" + event.getAmount();
    }
}
