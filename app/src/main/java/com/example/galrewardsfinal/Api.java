package com.example.galrewardsfinal;

import android.database.Observable;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Api {
    String BASE_URL = "http://mygalrewards.com/galrewards/api/login";
    //@GET("")
    //Call<List<Details_Pojo>> getstatus();

    String BASE_URL1 = "http://mygalrewards.com/galrewards/api/product/?id=en";
    @GET("en")
    Call<List<Results>> getsuperHeroes();

    String BASE_URL2 = "http://mygalrewards.com/galrewards/api/account/balance/?email=vijaykashyap265@gmail.com";
    @GET("vijaykashyap265@gmail.com")
    Call<List<ResultsBalance>> getsuperHeroesBalance();

    @GET("TicketView/{ticketviewdetail}")
    Observable<TicketViewDetail> getTicketViewDetail(@Path("ticketviewdetail")String ticketviewdetail);

}
