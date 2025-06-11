package com.ecommerce.model;

public class Product {
    private int productId;
    private String productName;
    private double price;
    private String description;
    private Category category;

    public Product(int productId, String productName, double price, String description, Category category) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.category = category;
    }

    public Product() {
        this.productId = -1;
        this.productName = "Unknown";
        this.price = 0.0;
        this.description = "N/A";
        this.category = new Category("C000", "Uncategorized", "Default category");
    }

    // Getters
    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public Category getCategory() {
        return category;
    }

    // Setters
    public void setPrice(double price) {
        this.price = price;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", category=" + (category != null ? category.getCategoryName() : "None") +
                '}';
    }
}
