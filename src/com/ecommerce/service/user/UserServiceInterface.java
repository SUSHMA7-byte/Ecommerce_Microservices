package com.ecommerce.service.user;

import java.util.*;

import com.ecommerce.model.Product;

public interface UserServiceInterface {

    List<Product> browseProducts();

    void addToCart(int productId, int quantity);

    void removeFromCart(int productId);

    Map<Integer, Integer> viewCart();

    //void printCartSummary(Map<String, Integer> summary);

    static List<String> getPopularSearches() {
        return Arrays.asList("Laptop", "Smartphone", "Python");
    }
}

