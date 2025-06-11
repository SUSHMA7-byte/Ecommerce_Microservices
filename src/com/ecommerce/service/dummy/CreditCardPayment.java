package com.ecommerce.service.dummy;

import com.ecommerce.exception.PaymentFailedException;

public class CreditCardPayment extends PaymentService {

        private String cardNumber;

        public CreditCardPayment(double amount, String cardNumber, String methodName) throws PaymentFailedException {
            super(amount, methodName);
            this.cardNumber = cardNumber;
        }

        @Override
        public void pay() {

            System.out.println("Paying Rs." + getAmount() + " using Credit Card: " + cardNumber);
        }
    }