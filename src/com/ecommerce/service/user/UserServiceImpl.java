package com.ecommerce.service.user;

import java.util.*;

import com.ecommerce.model.Category;
import com.ecommerce.model.Product;

public class UserServiceImpl implements UserServiceInterface {
    private List<Product> products = new ArrayList<>();
    private Map<Integer, Integer> cart = new HashMap<>();

    public UserServiceImpl(List<Product> products) {
        this.products = products;
    }

    public UserServiceImpl() {
        Category electronics = new Category("1", "Electronics", "Electronic items like gadgets");
        Category clothing = new Category("2", "Clothing", "Clothes for men and women");
        Category books = new Category("3", "Books", "Books across various genres");

        products.add(new Product(1, "Wireless Mouse", 599.99, "Ergonomic wireless mouse with USB receiver", electronics));
        products.add(new Product(2, "Mechanical Keyboard", 1299.50, "RGB backlit mechanical keyboard", electronics));
        products.add(new Product(3, "Smartphone", 15999.00, "6.5 inch display, 128GB storage, 48MP camera", electronics));
        products.add(new Product(4, "Bluetooth Speaker", 1999.75, "Portable speaker with 10 hours battery life", electronics));
        products.add(new Product(5, "Laptop", 45999.99, "14-inch laptop with 8GB RAM and 512GB SSD", electronics));
        products.add(new Product(6, "HD Monitor", 8999.00, "24-inch Full HD LED monitor", electronics));

        products.add(new Product(7, "Men's T-Shirt", 499.00, "100% cotton crew neck t-shirt", clothing));
        products.add(new Product(8, "Women's Jeans", 1499.00, "Slim-fit denim jeans for women", clothing));
        products.add(new Product(9, "Jacket", 2499.50, "Water-resistant windbreaker jacket", clothing));
        products.add(new Product(10, "Sneakers", 1999.00, "Comfortable running shoes for everyday wear", clothing));

        products.add(new Product(11, "The Great Gatsby", 299.00, "Classic novel by F. Scott Fitzgerald", books));
        products.add(new Product(12, "Introduction to Python", 799.50, "Beginner’s guide to Python programming", books));
        products.add(new Product(13, "Atomic Habits", 499.00, "Self-help book by James Clear", books));
        products.add(new Product(14, "World Atlas", 999.00, "Geographical reference with maps and facts", books));

    }

    @Override
    public List<Product> browseProducts() {
        return products;
    }

    @Override
    public void addToCart(int productId, int quantity) {
        boolean exists = false;
        for (Product p : products) {
            if (p.getProductId() == productId) {
                exists = true;
                break;
            }
        }
        if (!exists) {
            System.out.println("Product ID " + productId + " does not exist.");
            return;
        }
        cart.put(productId, cart.getOrDefault(productId, 0) + quantity);
        System.out.println("Added Product ID " + productId + " with quantity " + quantity);
    }

    @Override
    public void removeFromCart(int productId) {
        if (cart.containsKey(productId)) {
            cart.remove(productId);
            System.out.println("Removed Product ID " + productId + " from cart.");
        } else {
            System.out.println("Product ID " + productId + " not found in cart.");
        }
    }

    @Override
    public Map<Integer, Integer> viewCart() {
        return cart;
    }

    /* @Override
    public void printCartSummary(Map<String, Integer> summary) {
        if (summary.isEmpty()) {
            System.out.println("Cart is empty.");
        } else {
            for (Map.Entry<String, Integer> entry : summary.entrySet()) {
                System.out.println("Product: " + entry.getKey() + ", Quantity: " + entry.getValue());
            }
        }
    } */
}
