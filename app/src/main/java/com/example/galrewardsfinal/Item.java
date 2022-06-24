package com.example.galrewardsfinal;

public class Item {
    private ProductNew productNew;
    private int quantity;

    public Item(){

    }


    public Item(ProductNew productNew, int quantity) {
        this.productNew = productNew;
        this.quantity = quantity;
    }

    public ProductNew getProductNew() {
        return productNew;
    }

    public void setProductNew(ProductNew productNew) {
        this.productNew = productNew;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
