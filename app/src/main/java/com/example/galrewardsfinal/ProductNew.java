package com.example.galrewardsfinal;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ProductNew implements Serializable {

    @SerializedName("id")
    private int id;

    @SerializedName("product_name_en")
    private String name;

    @SerializedName("points")
    private double price;

    @SerializedName("quantity")
    private int quantity;

    @SerializedName("product_thambnail")
    private String photo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
