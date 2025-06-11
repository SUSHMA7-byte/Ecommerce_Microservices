package com.ecommerce.main;

import java.util.*;
import com.ecommerce.model.*;
import com.ecommerce.service.dummy.CreditCardPayment;
import com.ecommerce.service.dummy.PaymentService;
import com.ecommerce.service.order.OrdersImplementation;
import com.ecommerce.service.paymentprocess.PaymentGateway;
import com.ecommerce.service.paymentprocess.PaymentMethod;
import com.ecommerce.service.user.UserServiceImpl;
import com.ecommerce.service.user.UserServiceInterface;
import com.ecommerce.service.orderprocessvalidator.*;
import com.ecommerce.exception.*;

public class EcommerceApp {
    public static void main(String[] args) throws PaymentFailedException {
        UserServiceInterface user = new UserServiceImpl();
        OrdersImplementation displayOrder = new OrdersImplementation(user);
        Scanner sc = new Scanner(System.in);

        Order currentOrder = null;
        int choice;

        do {
            System.out.println("\n--- E-COMMERCE MENU ---");
            System.out.println("1. View Products");
            System.out.println("2. Add to Cart");
            System.out.println("3. Remove from Cart");
            System.out.println("4. View Cart");
            System.out.println("5. Checkout");
            System.out.println("6. Place Order");
            System.out.println("7. View Popular Searches");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\nAvailable Products:");
                    ArrayList<Product> allProducts = (ArrayList<Product>) user.browseProducts();
                    for (int i = 0; i < allProducts.size(); i++) {
                        Product product = allProducts.get(i);
                        System.out.println("ID: " + product.getProductId() +
                                ", Name: " + product.getProductName()+
                                ", Price: ₹" + product.getPrice());
                    }
                    break;

                case 2:
                    System.out.print("Enter Product ID to add: ");
                    int addId = sc.nextInt();
                    System.out.print("Enter Quantity: ");
                    int qty = sc.nextInt();
                    user.addToCart(addId, qty);
                    break;

                case 3:
                    System.out.print("Enter Product ID to remove: ");
                    int removeId = sc.nextInt();
                    user.removeFromCart(removeId);
                    break;

                case 4:
                    System.out.println("\nYour Cart:");
                    Map<Integer, Integer> cart = user.viewCart();
                    if (cart.isEmpty()) {
                        System.out.println("Cart is empty.");
                    } else {
                        for (Map.Entry<Integer, Integer> entry : cart.entrySet()) {
                            int productId = entry.getKey();
                            int quantity = entry.getValue();
                            String name = " ";
                            double amount = 0.0;
                            ArrayList<Product> products = (ArrayList<Product>) user.browseProducts();
                            for (int i = 0; i < products.size(); i++) {
                                if (products.get(i).getProductId() == productId) {
                                    name = products.get(i).getProductName();
                                    amount = products.get(i).getPrice();
                                    break;
                                }
                            }
                            System.out.println("Product: " + name + ", Quantity: " + quantity + ", Price: "+ amount );
                        }
                    }
                    break;

                case 5:
                    Map<Integer, Integer> cartItems = user.viewCart();
                    ArrayList<Product> productList = (ArrayList<Product>) user.browseProducts();

                    if (cartItems == null || cartItems.isEmpty()) {
                        System.out.println("Cart is empty. Add products before checkout.");
                        break;
                    }

                    Customer customer = new Customer(101, "Sushma", "sushma@mail.com", "Bangalore", "9999999999");
                    Order order = new Order("ORD001", customer, "Pending");

                    Map<Integer, Product> productMap = new HashMap<>();
                    for (Product prod : productList) {
                        productMap.put(prod.getProductId(), prod);
                    }

                    Category defaultCategory = new Category("C101", "Electronics", "");

                    for (Map.Entry<Integer, Integer> entry : cartItems.entrySet()) {
                        int pid = entry.getKey();
                        int quantity = entry.getValue();

                        if (quantity <= 0) {
                            System.out.println("Skipping Product ID " + pid + " due to invalid quantity: " + quantity);
                            continue;
                        }

                        Product p = productMap.get(pid);
                        if (p != null) {
                            Product realProduct = new Product(pid, p.getProductName(), p.getPrice(), "", defaultCategory);
                            OrderItem item = new OrderItem("ITM" + pid, realProduct, quantity);

                            try {
                                OrderValidator.validateOrderItem(item);
                                order.getItems().add(item);
                            } catch (InvalidOrderException e) {
                                System.out.println("Validation Error: " + e.getMessage());
                            }
                        }
                    }

                    if (order.getItems().isEmpty()) {
                        System.out.println("No valid items in order to proceed with checkout.");
                        break;
                    }

                    double totalAmount = 0.0;
                    for (OrderItem item : order.getItems()) {
                        totalAmount += item.getPrice();
                    }
                    double discount = 0;
                    if (totalAmount > 50000) {
                        discount = totalAmount * 0.10;
                    } else if (totalAmount >= 20000) {
                        discount = totalAmount * 0.05;
                    }

                    double finalAmount = totalAmount - discount;

                    System.out.println("\nTotal: ₹" + totalAmount);
                    System.out.println("Discount: ₹" + discount);
                    System.out.println("Amount Payable: ₹" + finalAmount);
                    System.out.println("Order placed successfully!");

                    System.out.println("Total Amount: ₹" + totalAmount);

                    Scanner scanner = new Scanner(System.in);
                    PaymentMethod paymentMethod = PaymentGateway.selectPaymentMethod(scanner);

                    if (paymentMethod != null) {
                        paymentMethod.collectPaymentDetails(scanner);
                        paymentMethod.processPayment();
                    } else {
                        System.out.println("Invalid payment method selected.");
                        break;
                    }

                    System.out.println("Choose Order Type: 1 for Standard, any other number for Priority:");
                    int orderType = scanner.nextInt();

                    if (orderType == 1) {
                        order.setProcessingStrategy(new StandardOrderProcess());
                    } else {
                        order.setProcessingStrategy(new PriorityOrderProcessing());
                    }

                    currentOrder = order;

                    order.processOrder();
                    break;


                case 6:
                    displayOrder.displayOrderSummary(currentOrder);
                    break;

                case 7:
                    System.out.println("\nPopular Searches:");
                    List<String> searches = UserServiceInterface.getPopularSearches();
                    for (String prod : searches) {
                        System.out.println(prod);
                    }
                    break;

                case 8:
                    System.out.println("Exiting... Thank you for shopping with us!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 8);

        sc.close();
    }
}
