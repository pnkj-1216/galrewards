package com.example.galrewardsfinal;

public class Order {
    public String invoiceno;
    public int points;
    public String  statusinv;


    public Order() {

    }

    public Order(String invoiceno, int points, String statusinv) {

        this.invoiceno = invoiceno;
        this.points = points;
        this.statusinv = statusinv;
    }

    public String getInvoiceno() {
        return invoiceno;
    }

    public void setInvoiceno(String invoiceno) {
        this.invoiceno = invoiceno;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getStatusinv() {

        return statusinv;
    }

    public void setStatusinv(String statusinv) {
        this.statusinv = statusinv;
    }
}
