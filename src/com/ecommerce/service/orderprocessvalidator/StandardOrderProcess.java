package com.ecommerce.service.orderprocessvalidator;

import com.ecommerce.model.Order;

public class StandardOrderProcess implements OrderProcessingStrategy{
    public void processOrder(Order order){
        System.out.println("Processing order in standard mode for Order ID: " + order.getOrderId()+" and will " +
                "be delivered in 4-5 days");
    }
}
