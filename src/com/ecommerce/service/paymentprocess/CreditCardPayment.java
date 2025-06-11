package com.ecommerce.service.paymentprocess;

import java.util.Scanner;

public class CreditCardPayment implements PaymentMethod {
    private String cardNumber;
    private String cvv;
    private String expiry;

    @Override
    public void collectPaymentDetails(Scanner scanner) {
        do {
            System.out.print("Enter 16-digit Credit Card Number: ");
            cardNumber = scanner.nextLine();
        } while (!cardNumber.matches("\\d{16}"));

        do {
            System.out.print("Enter 3-digit CVV: ");
            cvv = scanner.nextLine();
        } while (!cvv.matches("\\d{3}"));

        do {
            System.out.print("Enter Expiry Date (MM/YY): ");
            expiry = scanner.nextLine();
        } while (!expiry.matches("^(0[1-9]|1[0-2])/\\d{2}$"));
    }

    @Override
    public void processPayment() {
        System.out.println("Processing Credit Card payment...");
    }
}
