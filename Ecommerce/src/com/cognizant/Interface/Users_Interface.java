package com.cognizant.Interface;

import java.util.List;
import java.util.Map;

import com.cognizant.model.Products;

public interface Users_Interface {
	
	   List<Products> browseProducts();
	    void addToCart(int productId, int quantity);
	    void removeFromCart(int productId);
	    Map<Integer, Integer> viewCart();
	    
	    default void printCartSummary(Map<String, Integer> cart) {
	        cart.forEach((productname, qty) -> {
	            System.out.println("Product name: " + productname + ", Quantity: " + qty);
	        });
	    }
	    
	    static List<String> getPopularSearches() {
	        return List.of("laptops", "phones", "headphones");
	    }

}
