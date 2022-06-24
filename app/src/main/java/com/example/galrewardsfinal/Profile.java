package com.example.galrewardsfinal;

public class Profile {

    public String firstname;
    public String lastname;
    public String email;
    public String pcc;
    public String signon;
    public String country;
    public String agencyname;
    private String dob;
    private String number;


    public Profile(){}


    public Profile(String firstname,String lastname,String email,String pcc,String signon,String country,String agencyname,String dob, String number) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.pcc = pcc;
        this.signon = signon;
        this.country = country;
        this.agencyname = agencyname;
        this.dob = dob;
        this.number = number;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPcc() {
        return pcc;
    }

    public void setPcc(String pcc) {
        this.pcc = pcc;
    }

    public String getSignon() {
        return signon;
    }

    public void setSignon(String signon) {
        this.signon = signon;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAgencyname() {
        return agencyname;
    }

    public void setAgencyname(String agencyname) {
        this.agencyname = agencyname;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
