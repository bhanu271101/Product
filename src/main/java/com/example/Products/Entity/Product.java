package com.example.Products.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;



@Entity
public class Product {

    @Id
    private Long mobileId;

    private String mobileName;

    private String descreption;

    private double price;

    private int quantity;

    private Long hubId;

    private double discount;

   

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public Long getHubId() {
        return hubId;
    }

    public void setHubId(Long hubId) {
        this.hubId = hubId;
    }

    // Getters and Setters
    public Long getMobileId() {
        return mobileId;
    }

    public void setMobileId(Long mobileId) {
        this.mobileId = mobileId;
    }

    public String getMobileName() {
        return mobileName;
    }

    public void setMobileName(String mobileName) {
        this.mobileName = mobileName;
    }

    public String getDescreption() {
        return descreption;
    }

    public void setDescreption(String descreption) {
        this.descreption = descreption;
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

   
}