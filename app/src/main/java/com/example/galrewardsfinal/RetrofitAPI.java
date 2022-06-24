package com.example.galrewardsfinal;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitAPI {

    @GET("guserid=MG565-BH12")

        // as we are calling data from array
        // so we are calling it with json object
        // and naming that method as getCourse();
    Call<Account> getCourse();
}
