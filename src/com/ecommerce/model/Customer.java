package com.ecommerce.model;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Customer{
    private int userId;
    private String userName;
    private String email;
    private String address;
    private String phone;
    private LocalDateTime createdAt;


    public Customer(int userId, String userName, String email, String address, String phone ){
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.createdAt = LocalDateTime.now();
    }

    public Customer() {
        this.userId = -1;
        this.userName = "Unknown";
        this.email = "N/A";
        this.phone = "N/A";
        this.address = "N/A";
        this.createdAt = LocalDateTime.now();
    }

    //Getters
    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getCreatedAt() {
        return createdAt.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH-mm-ss"));
    }

    //Setters
    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Customer Details:\n" +
                "User ID: " + userId + "\n" +
                "Name: " + userName + "\n" +
                "Email: " + email + "\n" +
                "Phone: " + phone + "\n" +
                "Address: " + address + "\n" +
                "Created At: " + getCreatedAt();
    }

    public static void main(String args[]){
        Customer cust = new Customer();
        System.out.println(cust);
    }
}
