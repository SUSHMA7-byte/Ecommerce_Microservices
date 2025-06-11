package com.ecommerce.service.paymentprocess;

import java.util.Scanner;

    public class UPIPayment implements PaymentMethod {
        private String upiId;

        @Override
        public void collectPaymentDetails(Scanner scanner) {
            do {
                System.out.print("Enter UPI ID (e.g., name@bank): ");
                upiId = scanner.nextLine();
            } while (!upiId.matches("^[\\w.-]+@[\\w.-]+$"));
        }

        @Override
        public void processPayment() {
            System.out.println("Processing UPI payment...");
        }
    }
