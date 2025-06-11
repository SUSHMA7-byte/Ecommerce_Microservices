package com.cognizant.model;

public class Products {
	
	private int product_id;
	private int user_id;
	private String product_name;
	private double price;
	private int quantity;
	private String category;
	
	@Override
	public String toString() {
		return "Products_Impl [product_id=" + product_id + ", user_id=" + user_id + ", product_name=" + product_name
				+ ", price=" + price + ", quantity=" + quantity + ", category=" + category + "]";
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Products(int productId, String productName, double price) {
        this.product_id = productId;
        this.product_name = productName;
        this.price = price;
    }

	
	

}
