package com.ecommerce.model;

import com.ecommerce.service.orderprocessvalidator.OrderProcessingStrategy;
import com.ecommerce.service.dummy.PaymentService;

import java.time.*;
import java.util.*;

public class Order {
    private String orderId;
    private Customer customer;
    private List<OrderItem> items = new ArrayList<>();
    private LocalDateTime orderDate;
    private String status;
    private PaymentService payment;
    private OrderProcessingStrategy processingStrategy;

    public Order(String orderId, Customer customer, String status) {
        this.orderId = orderId;
        this.customer = customer;
        this.orderDate = LocalDateTime.now();
        this.status = status;
    }

    public Order() {
        this.orderDate = LocalDateTime.now();
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public void setPayment(PaymentService payment) {
        this.payment = payment;
    }

    public PaymentService getPayment() {
        return payment;
    }

    public void setProcessingStrategy(OrderProcessingStrategy strategy) {
        this.processingStrategy = strategy;
    }

    public void processOrder() {
        if (processingStrategy != null) {
            processingStrategy.processOrder(this);
        } else {
            System.out.println("No processing strategy set for Order ID: " + orderId);
        }
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", orderDate=" + orderDate +
                ", status='" + status + '\'' +
                '}';
    }
}
