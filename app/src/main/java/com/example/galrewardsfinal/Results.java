package com.example.galrewardsfinal;

import com.google.gson.annotations.SerializedName;

public class Results {
    @SerializedName("product_name_en")
    private String superProductName;

    public Results (String product_name_en){
        this.superProductName = product_name_en;
    }

    public String getName() {
        return superProductName;
    }

}
