package com.example.galrewardsfinal;

public class Category {
    public String title;
    public int rating;
    public int year;
    public int id;
    public String img;
    public String country;
    public String catname;
    public int idpro;

    public Category() {

    }
    
    public Category(String title, int rating, int year,int id,String img,String country,String catname,int idpro) {
        this.title = title;
        this.rating = rating;
        this.year = year;
        this.id = id;
        this.img = img;
        this.country = country;
        this.catname = catname;
        this.idpro = idpro;
    }

    public int getIdpro() {
        return idpro;
    }

    public void setIdpro(int idpro) {
        this.idpro = idpro;
    }

    public String getImg(){
        return img;
    }

    public void setImg(String img){
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
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

    public void setCatname(String catname)   {
        this.catname = catname;
    }
}
