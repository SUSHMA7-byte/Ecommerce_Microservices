package com.ecommerce.model;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Payment {
    private String paymentId;
    private double amount;
    private String paymentMethod;
    private LocalDateTime paymentDate;

    public Payment(String paymentId, double amount, String method, LocalDateTime paymentDate) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.paymentMethod = method;
        this.paymentDate = paymentDate;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public double getAmount() {
        return amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public String getPaymentDateFormatted() {
        return paymentDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
    }

}
