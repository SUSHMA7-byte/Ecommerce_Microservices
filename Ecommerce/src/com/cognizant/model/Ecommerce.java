package com.cognizant.model;

import java.util.Map;
import java.util.Scanner;

import com.cognizant.Interface.Users_Interface;
import com.cognizant.Interfaceimpl.Users_Impl;

public class Ecommerce {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Users_Interface user = new Users_Impl();
        Scanner sc = new Scanner(System.in);

        // Sample Products
        user.browseProducts().add(new Products(1, "Laptop", 50000));
        user.browseProducts().add(new Products(2, "Phone", 30000));
        user.browseProducts().add(new Products(3, "Headphones", 3000));

        int choice;
        do {
            System.out.println("\n--- E-COMMERCE MENU ---");
            System.out.println("1. View Products");
            System.out.println("2. Add to Cart");
            System.out.println("3. Remove from Cart");
            System.out.println("4. View Cart");
            System.out.println("5. View Cart Summary");
            System.out.println("6. View Popular Searches");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\nAvailable Products:");
                    for (Products product : user.browseProducts()) {
                        System.out.println("ID: " + product.getProduct_id() +
                                ", Name: " + product.getProduct_name() +
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
                            String name = user.browseProducts().stream()
                                    .filter(p -> p.getProduct_id() == productId)
                                    .map(Products::getProduct_name)
                                    .findFirst().orElse("Unknown");
                            System.out.println("Product: " + name + ", Quantity: " + quantity);
                        }
                    }
                    break;

                case 5:
                    System.out.println("\nCart Summary:");
                    // For summary, map ProductName -> Quantity
                    Map<Integer, Integer> cartSummary = user.viewCart();
                    Map<String, Integer> summary = new java.util.HashMap<>();
                    for (Map.Entry<Integer, Integer> entry : cartSummary.entrySet()) {
                        String name = user.browseProducts().stream()
                                .filter(p -> p.getProduct_id() == entry.getKey())
                                .map(Products::getProduct_name)
                                .findFirst().orElse("Unknown");
                        summary.put(name, entry.getValue());
                    }
                    user.printCartSummary(summary);
                    break;

                case 6:
                    System.out.println("\nPopular Searches:");
                    Users_Interface.getPopularSearches().forEach(System.out::println);
                    break;

                case 7:
                    System.out.println("Exiting... Thank you for shopping with us!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 7);

        sc.close();

	}

}
