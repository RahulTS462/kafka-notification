package com.eatit.notification.event;

import lombok.Data;

@Data
public class OrderEvent {
    private String orderId;
    private String restaurantName;
    private double amount;
}
