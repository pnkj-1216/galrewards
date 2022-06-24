package com.example.galrewardsfinal;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface OrdInvoice {

    @GET("order")
    Call<List> getOrder();
}


