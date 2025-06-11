package com.ecommerce.service.orderprocessvalidator;

import com.ecommerce.model.Order;

public class PriorityOrderProcessing implements OrderProcessingStrategy {
    @Override
    public void processOrder(Order order) {
        System.out.println("Processing order in priority mode for Order ID: " + order.getOrderId()+" and will be delivered in a day");
    }
}
