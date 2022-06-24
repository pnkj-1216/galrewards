package com.example.galrewardsfinal;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface OrderPlace {
    String URL_BASE = "http://mygalrewards.com/galrewards/api/order/";

    @Headers("Content-Type: application/json")
    @POST("order")
    Call<Category>getTitle(@Body String body);
    Call<Category>getRating(@Body String body);
    Call<Category>getYear(@Body String body);
    Call<Category>getid(@Body String body);
    Call<Category>getCountry(@Body String body);
    Call<Category>getcatname(@Body String body);
    Call<Category>getidpro(@Body String body);

}
