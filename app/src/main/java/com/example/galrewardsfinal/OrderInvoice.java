package com.example.galrewardsfinal;

public class OrderInvoice {
    private int points;
    private int subtotal;
    private int qty;
    private String productname;
    private String invoiceno;
    private String status;
    private String invoimg;


    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getInvoiceno() {
        return invoiceno;
    }

    public void setInvoiceno(String invoiceno) {
        this.invoiceno = invoiceno;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInvoimg() {
        return invoimg;
    }

    public void setInvoimg(String invoimg) {
        this.invoimg = invoimg;
    }
}
