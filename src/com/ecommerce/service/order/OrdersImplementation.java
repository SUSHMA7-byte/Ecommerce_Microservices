package com.ecommerce.service.order;

import com.ecommerce.model.Order;
import com.ecommerce.model.OrderItem;
import com.ecommerce.model.Product;
import com.ecommerce.service.user.UserServiceInterface;

import java.util.*;

public class OrdersImplementation implements OrdersInterface {

    private UserServiceInterface user;

    public OrdersImplementation(UserServiceInterface user) {
        this.user = user;
    }

    @Override
    public void displayOrderSummary(Order order) {
        if (order == null || order.getItems().isEmpty()) {
            System.out.println("No order found. Please complete checkout first.");
            return;
        }

        System.out.println("\n--- ORDER SUMMARY ---");

        for (OrderItem item : order.getItems()) {
            System.out.println("Product: " + item.getProduct().getProductName()
                    + ", Quantity: " + item.getQuantity()
                    + ", Subtotal: ₹" + String.format("%.2f", item.getPrice()));
        }

        double total = order.getItems().stream().mapToDouble(OrderItem::getPrice).sum();
        System.out.println("\nTotal Paid: ₹" + String.format("%.2f", total));
        System.out.println("Order placed successfully!");
        System.out.println("Order ID: " + order.getOrderId());
        System.out.println("Order Date: " + order.getOrderDate());
        System.out.println("Status: " + order.getStatus());
    }

}
