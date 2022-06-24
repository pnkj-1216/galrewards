package com.example.galrewardsfinal;

public class TicketList {

    private String needassistance;
    private String comment;
    private int ticketdate;
    private String status;
    //private String view;

    public TicketList(){

    }

    public TicketList(String needassistance,String comment,int ticketdate,String status){

        this.needassistance = needassistance;
        this.comment = comment;
        this.ticketdate = ticketdate;
        this.status  = status;
      //  this.view = view;

    }

    public String getNeedassistance() {
        return needassistance;
    }

    public void setNeedassistance(String needassistance) {
        this.needassistance = needassistance;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getTicketdate() {
        return ticketdate;
    }

    public void setTicketdate(int ticketdate) {
        this.ticketdate = ticketdate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
