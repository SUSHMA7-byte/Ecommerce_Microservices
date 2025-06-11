package com.ecommerce.service.dummy;

import com.ecommerce.exception.PaymentFailedException;

public class PaypalPayment extends PaymentService {

        private String email;

        public PaypalPayment(double amount, String email,String methodName) throws PaymentFailedException {
            super(amount,methodName);
            this.email = email;
        }

        @Override
        public void pay() {
            System.out.println("Paying Rs." + getAmount() + " using PayPal: " + email);
        }
    }
