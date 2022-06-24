package com.example.galrewardsfinal;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientAccountBalance {
    private static RetrofitClientAccountBalance instance = null;
    private Api myApiAccount;

    RetrofitClientAccountBalance() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.BASE_URL2)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myApiAccount = retrofit.create(Api.class);
    }

    public static synchronized RetrofitClientAccountBalance getInstanceAccount() {
        if (instance == null) {
            instance = new RetrofitClientAccountBalance();
        }
        return instance;
    }

    public Api getMyApiAccount() {
        return myApiAccount;
    }
}
