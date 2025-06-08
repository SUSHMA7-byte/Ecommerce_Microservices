package com.cognizant.Interfaceimpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cognizant.Interface.Users_Interface;
import com.cognizant.model.Products;

public class Users_Impl implements Users_Interface {

	private List<Products> products = new ArrayList<>();
    private Map<Integer, Integer> cart = new HashMap<>();

	@Override
	public List<Products> browseProducts() {
		// TODO Auto-generated method stub
		return products;
	}

	@Override
	public void addToCart(int productId, int quantity) {
		// TODO Auto-generated method stub
		cart.put(productId, cart.getOrDefault(productId, 0) + quantity);
        System.out.println("Added Product ID " + productId + " with quantity " + quantity);
		
	}

	@Override
	public void removeFromCart(int productId) {
		// TODO Auto-generated method stub
		 if (cart.containsKey(productId)) {
	            cart.remove(productId);
	            System.out.println("Removed Product ID " + productId + " from cart.");
	        } else {
	            System.out.println("Product ID " + productId + " not found in cart.");
	        }
		
	}

	@Override
	public Map<Integer, Integer> viewCart() {
		// TODO Auto-generated method stub
		return cart;
	}
	
	
}
