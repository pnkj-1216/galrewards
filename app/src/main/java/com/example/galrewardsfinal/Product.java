package com.example.galrewardsfinal;


import android.net.Uri;
import android.widget.ImageView;

public class Product {
    public String categoriesname;
    public int id;
    public int categoriesstatus;
    public String country;
    public String catname;
    public String imgcat;


    public Product(){

    }

public Product(String categoriesname, int id, int categoriesstatus,String country,String catname,String imgcat) {
    this.categoriesname = categoriesname;
    this.id = id;
    this.categoriesstatus = categoriesstatus;
    this.country = country;
    this.catname = catname;
    this.imgcat = imgcat;
    }

    public String getCategoriesname() {
        return categoriesname;
    }

    public void setCategoriesname(String categoriesname) {
        this.categoriesname = categoriesname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoriesstatus() {
        return categoriesstatus;
    }

    public void setCategoriesstatus(int categoriesstatus) {
        this.categoriesstatus = categoriesstatus;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCatname() {
        return catname;
    }

    public void setCatname(String catname) {
        this.catname = catname;
    }


    public String getImgcat() {
        return imgcat;
    }

    public void setImgcat(String imgcat) {
        this.imgcat = imgcat;
    }
}

