package com.example.galrewardsfinal;

public class DataModel {
    //private int user_id;
    private String need_assistance;
    private String comment;

    public DataModel(String need_assistance, String comment) {
      //  this.user_id = user_id;
        this.need_assistance = need_assistance;
        this.comment = comment;
    }

    //public int getUser_id()
    //{
      //  return user_id;
    //}
    //public int setUser_id(int user_id )
    //{
      //  this.user_id = user_id;
    //}

    public String getNeed_assistance()
    {
        return need_assistance;
    }

    public void setNeed_assistance(String need_assistance) {
        this.need_assistance = need_assistance;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}
