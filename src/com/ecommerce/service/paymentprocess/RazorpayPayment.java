package com.ecommerce.service.paymentprocess;

import java.util.Scanner;

public class RazorpayPayment implements PaymentMethod {

    @Override
    public void collectPaymentDetails(Scanner scanner) {
        // Razorpay requires no input in this simulation
        System.out.println("Initiating Razorpay...");
    }

    @Override
    public void processPayment() {
        System.out.println("Processing Razorpay payment...");
    }
}
