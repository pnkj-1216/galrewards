package com.example.galrewardsfinal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cart implements Serializable {
    public String pcartname;
    public int cartpoints;
    public int carttotal;
    public int  procartstatus;
    public int itemremove;
    public String pcartimg;


    public Cart() {

    }

    public int getItemremove() {
        return itemremove;
    }

    public void setItemremove(int itemremove) {
        this.itemremove = itemremove;
    }

    public Cart(String pcartname, int cartpoints, int carttotal, int procartstatus, int itemremove, String pcartimg) {

        this.pcartname = pcartname;
        this.cartpoints = cartpoints;
        this.carttotal = carttotal;
        this.procartstatus = procartstatus;
        this.itemremove = itemremove;
        this.pcartimg = pcartimg;
    }

    public String getPcartname() {
        return pcartname;
    }

    public void setPcartname(String pcartname) {
        this.pcartname = pcartname;
    }

    public int getCartpoints() {
        return cartpoints;
    }

    public void setCartpoints(int cartpoints) {
        this.cartpoints = cartpoints;
    }

    public int getCarttotal() {
        return carttotal;
    }

    public void setCarttotal(int carttotal) {
        this.carttotal = carttotal;
    }

    public int getProcartstatus() {
        return procartstatus;
    }

    public void setProcartstatus(int procartstatus)
    {
        this.procartstatus = procartstatus;

    }


    public String getPcartimg() {
        return pcartimg;
    }

    public void setPcartimg(String pcartimg) {
        this.pcartimg = pcartimg;
    }
}

    //Old Code
    /*
    private static List<Item> items = new ArrayList<Item>();

    public static void insert(Item item){
        items.add(item);
    }

    public static void update(ProductNew productNew){
        int index = getIndex(productNew);
        int quantity = items.get(index).getQuantity() + 1;
        items.get(index).setQuantity(quantity);
    }

    public static void remove(ProductNew productNew){   
        int index = getIndex(productNew);
        items.remove(index);
    }

    public static List<Item> contents(){
        return items;
    }

    public static double total(){
        double s = 0;
        for(Item item : items){
            s+= item.getProductNew().getPrice() * item.getQuantity();
        }
        return s;
    }

    public static boolean isExists(ProductNew productNew){
        return getIndex(productNew)  != -1;
    }

    private static int getIndex(ProductNew product){
        for (int i = 0; i <items.size() ; i++) {
            if(items.get(i).getProductNew().getId() == product.getId()){
                return i;
            }
        }
        return -1;
    }
}
*/