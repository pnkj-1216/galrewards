package com.example.galrewardsfinal;

public class JavaClassOrderStatusWithInvoice {

    private String Productname;
    private String OrderNumber;
    private int pqty;
    private int ppoints;
    private String OrderStatus;
    private int subtotal;
    private String invoimg;

    public JavaClassOrderStatusWithInvoice(){

    }

    public  JavaClassOrderStatusWithInvoice(String Productname, String OrderNumber, int pqty, int ppoints, String OrderStatus,int subtotal,
                                            String invoimg){

        this.Productname = Productname;
        this.OrderNumber = OrderNumber;
        this.pqty = pqty;
        this.ppoints = ppoints;
        this.OrderStatus = OrderStatus;
        this.subtotal = subtotal;
        this.invoimg  = invoimg;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }

    public String getProductname() {
        return Productname;
    }

    public void setProductname(String productname) {
        Productname = productname;
    }

    public String getOrderNumber() {
        return OrderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        OrderNumber = orderNumber;
    }

    public int getPqty() {
        return pqty;
    }

    public void setPqty(int pqty) {
        this.pqty = pqty;
    }

    public int getPpoints() {
        return ppoints;
    }

    public void setPpoints(int ppoints) {
        this.ppoints = ppoints;
    }

    public String getOrderStatus() {
        return OrderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        OrderStatus = orderStatus;
    }

    public String getInvoimg() {
        return invoimg;
    }

    public void setInvoimg(String invoimg) {
        this.invoimg = invoimg;
    }
}
