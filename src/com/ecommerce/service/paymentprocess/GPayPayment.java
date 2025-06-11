package com.ecommerce.service.paymentprocess;

import java.util.Scanner;

public class GPayPayment implements PaymentMethod {
        private String mobile;

        @Override
        public void collectPaymentDetails(Scanner scanner) {
            do {
                System.out.print("Enter 10-digit GPay mobile number: ");
                mobile = scanner.nextLine();
            } while (!mobile.matches("\\d{10}"));
        }

        @Override
        public void processPayment() {
            System.out.println("Processing GPay payment...");
        }
}