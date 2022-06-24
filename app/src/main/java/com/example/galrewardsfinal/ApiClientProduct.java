package com.example.galrewardsfinal;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClientProduct {
    private static Retrofit retrofit = null;

    public static Retrofit getClient(){

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
    OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
    retrofit = new Retrofit.Builder()
            .baseUrl("http://mygalrewards.com/galrewards/api/product/?id=en")
                .addConverterFactory(GsonConverterFactory.create())
            .client(client)
                .build();
                return retrofit;
}

}
