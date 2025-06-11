package com.ecommerce.service.orderprocessvalidator;

import com.ecommerce.exception.InvalidOrderException;
import com.ecommerce.model.Customer;
import com.ecommerce.model.Product;
import com.ecommerce.model.OrderItem;

    public class OrderValidator {

        public static void validateCustomer(Customer customer) throws InvalidOrderException {
            if (customer == null) {
                throw new InvalidOrderException("Customer cannot be null.");
            }
            if (customer.getUserName() == null) {
                throw new InvalidOrderException("Customer Name cannot be null.");
            }
            if(customer.getPhone().length()!=10){
                throw new InvalidOrderException("Invalid Contact");
            }
        }

        public static void validateProduct(Product product) throws InvalidOrderException {
            if (product == null) {
                throw new InvalidOrderException("Product cannot be null.");
            }
        }

        public static void validateOrderItem(OrderItem item) throws InvalidOrderException {
            if (item == null) {
                throw new InvalidOrderException("Order item cannot be null.");
            }
            if (item.getQuantity() <= 0) {
                throw new InvalidOrderException("Quantity must be greater than zero.");
            }
        }


    }

