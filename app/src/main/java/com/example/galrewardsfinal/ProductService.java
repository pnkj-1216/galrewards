package com.example.galrewardsfinal;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ProductService {
    @GET("en")
    Call<List<Product>> en();

    @GET("en/{id}")
    Call<Product>en(@Path("id")int id);
}
