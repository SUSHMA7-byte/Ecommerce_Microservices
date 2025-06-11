package com.ecommerce.service.orderprocessvalidator;

import com.ecommerce.model.Order;

public interface OrderProcessingStrategy {
    void processOrder(Order order);
}
