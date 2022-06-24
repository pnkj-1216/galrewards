package com.example.galrewardsfinal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CartItem implements Serializable {

    private List<CartItem>items;

    public void CartActivity(){
    items = new ArrayList<CartItem>(0);
    }
}
