package com.example.galrewardsfinal;

public class BestDeal {
    public String productname;
    public int points;
    public String img;

    public BestDeal() {

    }

    public BestDeal(String productname, int points,String img){
        //int id,,String country,String catname) {
        this.productname = productname;
        this.points = points;
        this.img = img;

        //this.year = year;
        //this.id = id;
        // this.country = country;
        //this.catname = catname;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
