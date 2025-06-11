package com.ecommerce.service.paymentprocess;

import java.util.Scanner;

public class NetBankingPayment implements PaymentMethod {
    private String bankName;

    @Override
    public void collectPaymentDetails(Scanner scanner) {
        do {
            System.out.print("Enter your Bank Name: ");
            bankName = scanner.nextLine().trim();
        } while (bankName.isEmpty());
    }

    @Override
    public void processPayment() {
        System.out.println("Processing Net Banking payment with " + bankName + "...");
    }
}
