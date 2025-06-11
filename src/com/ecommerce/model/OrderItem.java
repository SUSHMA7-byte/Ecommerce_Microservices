package com.ecommerce.model;

public class OrderItem {

    private String orderItemId;
    private Product product;
    private int quantity;
    private double price;

    public OrderItem(String orderItemId, Product product, int quantity) {
        this.orderItemId = orderItemId;
        this.product = product;
        this.quantity = quantity;
        this.price = product.getPrice() * quantity;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity(){
        return quantity;
    }

    public OrderItem() {}

    public Product getProduct() {
        return product;
    }

    public void setOrderItemId(String orderItemId) {
        this.orderItemId = orderItemId;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
