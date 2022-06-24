package com.example.galrewardsfinal;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ChangePassword {

    @POST("email")
    Call<ChngPassword> createPost(@Body ChngPassword chngPassword);
}
