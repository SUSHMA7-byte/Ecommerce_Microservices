package com.ecommerce.service.dummy;

import com.ecommerce.exception.PaymentFailedException;

public abstract class PaymentService {
    private double amount;
    private String methodName;

    public PaymentService(double amount, String methodName) throws PaymentFailedException {
        if (amount <= 0) {
            throw new PaymentFailedException("Amount must be greater than zero.");
        }
        this.amount = amount;
        this.methodName = methodName;
    }

    public double getAmount() {
        return amount;
    }

    public void paymentDetails() {
        System.out.println("Initiating payment of Rs." + amount +" using "+ methodName);
    }

    public abstract void pay();

}
