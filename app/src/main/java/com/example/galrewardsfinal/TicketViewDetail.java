package com.example.galrewardsfinal;

public class TicketViewDetail {

    private String nedassistance;
    private String coment;
    private String staus;
    private String dte;

    public TicketViewDetail(){

    }

    public TicketViewDetail(String nedassistance, String coment,String staus, String dte){
        this.nedassistance = nedassistance;
        this.coment = coment;
        this.staus = staus;
        this.dte = dte;
    }

    public String getNedassistance() {
        return nedassistance;
    }

    public void setNedassistance(String nedassistance) {
        this.nedassistance = nedassistance;
    }

    public String getComent() {
        return coment;
    }

    public void setComent(String coment) {
        this.coment = coment;
    }

    public String getStaus() {
        return staus;
    }

    public void setStaus(String staus) {
        this.staus = staus;
    }

    public String getDte() {
        return dte;
    }

    public void setDte(String dte) {
        this.dte = dte;
    }
}
