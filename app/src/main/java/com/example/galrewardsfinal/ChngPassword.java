package com.example.galrewardsfinal;

public class ChngPassword {

    private String email;
    private String newpassword;
    private String confpassword;

    public ChngPassword(String email,String newpassword,String confpassword){
        this.email = email;
        this.newpassword = newpassword;
        this.confpassword = confpassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNewpassword() {
        return newpassword;
    }

    public void setNewpassword(String newpassword) {
        this.newpassword = newpassword;
    }

    public String getConfpassword() {
        return confpassword;
    }

    public void setConfpassword(String confpassword) {
        this.confpassword = confpassword;
    }
}
