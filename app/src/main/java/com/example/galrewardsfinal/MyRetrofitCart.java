package com.example.galrewardsfinal;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyRetrofitCart {
    private static final String BASE_URL="https://uniqueandrocode.000webhostapp.com/hiren/androidtutorial/mycart/";
    private static MyRetrofitCart myClient;
    private Retrofit retrofit;

    private MyRetrofitCart(){

        retrofit=new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
    }
    public static synchronized MyRetrofitCart getInstance(){
        if (myClient==null){
            myClient=new MyRetrofitCart();
        }
        return myClient;
    }
    //public CartApi getMyApi(){
        //return retrofit.create(CartApi.class);
   // }
}
