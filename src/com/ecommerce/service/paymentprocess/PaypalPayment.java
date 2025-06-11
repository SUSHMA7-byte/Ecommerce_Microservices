package com.ecommerce.service.paymentprocess;

import java.util.Scanner;

public class PaypalPayment implements PaymentMethod {
    private String email;

    @Override
    public void collectPaymentDetails(Scanner scanner) {
        do {
            System.out.print("Enter PayPal email address: ");
            email = scanner.nextLine();
        } while (!email.matches("^[\\w.-]+@[\\w.-]+\\.\\w{2,}$"));
    }

    @Override
    public void processPayment() {
        System.out.println("Processing PayPal payment...");
    }
}
