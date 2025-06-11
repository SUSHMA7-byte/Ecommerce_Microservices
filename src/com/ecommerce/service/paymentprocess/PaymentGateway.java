package com.ecommerce.service.paymentprocess;

import java.util.Scanner;

public class PaymentGateway {

    public static PaymentMethod selectPaymentMethod(Scanner scanner) {
        System.out.println("\n=== Choose a Payment Method ===");
        System.out.println("1. Credit Card");
        System.out.println("2. GPay");
        System.out.println("3. Razorpay");
        System.out.println("4. Net Banking");
        System.out.println("5. PhonePe");
        System.out.println("6. PayPal");
        System.out.println("7. UPI");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        return switch (choice) {
            case 1 -> new CreditCardPayment();
            case 2 -> new GPayPayment();
            case 3 -> new RazorpayPayment();
            case 4 -> new NetBankingPayment();
            case 5 -> new PhonePePayment();
            case 6 -> new PaypalPayment();
            case 7 -> new UPIPayment();
            default -> null;
        };
    }
}
