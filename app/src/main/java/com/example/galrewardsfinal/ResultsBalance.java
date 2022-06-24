package com.example.galrewardsfinal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

    public class ResultsBalance
{

    @SerializedName("closing_bal")
    private int closing_bal;
    //@Expose

    @SerializedName("total_pointused")
    private int total_pointused;
   // @Expose


    private String superProductName;

    public ResultsBalance (String product_name_en)
    {
        this.superProductName = product_name_en;
    }

    public String getName()
    {
        return superProductName;
    }
}
