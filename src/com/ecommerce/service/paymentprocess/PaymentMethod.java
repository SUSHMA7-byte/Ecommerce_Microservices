package com.ecommerce.service.paymentprocess;

import java.util.*;

public interface PaymentMethod {
    void collectPaymentDetails(Scanner scanner);
    void processPayment();
}
