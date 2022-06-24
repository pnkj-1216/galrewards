package com.example.galrewardsfinal;

//import com.google.android.gms.analytics.ecommerce.Product;

import java.util.Locale;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UserService {

    @POST("")

        //on below line we are creating a method to post our data.
    Call<DataModel> createPost(@Body DataModel dataModel);

    @POST("/post")
    @FormUrlEncoded
    Call<POST> savePost(@Field("id") long id,
                        @Field("email") String email,
                        @Field("password") String password,
                        @Field("first_name") String firstname);

    //@POST(ApiUtils.BASE_URL)
  //  Call login(@Path("email") String email, @Path("password") String password , @Path("first_name") String firstname);



    @FormUrlEncoded
    @GET(ApiUtils.BASE_Profile)
    Call<ProfileActivity> getAllData(@Field("id")long id,
                                  @Field("first_name")String firstname,
                                  @Field("last_name")String lastname,
                                  @Field("email")String email,
                                  @Field("country_name") String countryname,
                                  @Field("date_of_birth")int dateofbirth,
                                  @Field("contact")int contact,
                                  @Field("points")int points,
                                  @Field("pcc")String pcc,
                                  @Field("signon")String signon);

    @GET("getData/{id}/{first_name}/{last_name}/{email}/{country_name}/{date_of_birth}/{contact}/{points}/{pcc}/{sign_on}")
    Call<ProfileActivity >getAllData(@Path("id")Long id, @Path("first_name") String firstname, @Path("last_name") String lastname ,
                                     @Path("email") String email, @Path("country_name") String countryname,
                                     @Path("date_of_birth") int dateofbirth, @Path("contact")int contact,
            @Path("points") int points, @Path("pcc")String pcc, @Path("signon")String signon);


    @FormUrlEncoded
    @POST(ApiUtils.BASE_AccountBalance)
    Call<AccountBalance>BALANCE_CALL(@Field("email") String email, @Field("points") int points ,
                                     @Field("closing_bal") int closingbalance);

    //@POST("id/{email}/{points}/{closingbalance}")


    @POST("/GET")
    @FormUrlEncoded
    Call<GET>saveGet(@Path("email") String email, @Path("points") int points , @Path("closing_bal") int closing_bal);

    @FormUrlEncoded
    @POST(ApiUtils.BASE_URLCat)
    Call<Locale.Category>BALANCE_CALL(@Field("id") long id, @Field("categories_name_en") String categoriesen,
                                      @Field("categories_name_fr") String categoriesfr);

    @FormUrlEncoded
    @POST(ApiUtils.BASE_Product)
    Call<Product>BALANCE_CALL(@Field("product_name_en") String producten, @Field("product_thambnail") String productthum ,
                              @Field("points") String points);


    @FormUrlEncoded
    @POST(ApiUtils.BASE_Order)
    Call<Product>BALANCE_CALL(@Field("product_id") String productid, @Field("product_qty") String productqty ,
                              @Field("points") int points,
                              @Field("email")String email,@Field("subtotal") int subtotal);

    @FormUrlEncoded
    @POST(ApiUtils.BASE_Ticket)
    Call<Product>BALANCE_CALL(@Field("user_id")int userid, @Field("need_assistance") String needassistance,
                              @Field("ticket_date") int date, @Field("status") String status);

    @FormUrlEncoded
    @POST(ApiUtils.BASE_TicketStatus)
    Call<Product>BALANCE_CALL(@Field("id")int id, @Field("user_id")String userid,
                              @Field("need_assistance")String needassistance, @Field("ticket_date")String ticketdate);

   //@FormUrlEncoded
    //@POST(ApiUtils.BASE_ForgotPassword)
    //Call<ForgotPassword>BALANCE_CALL(@Field("email")String email, @Field("password")String password,
                                  //   @Field("confirm_password")String confirmpassword);


   //@FormUrlEncoded
    //@POST(ApiUtils.BASE_SliderImage)
    //Call<SliderActivity>BALANCE_CALL(@Field("id")int id, @Field("image") String image, @Field("slider_status") String status);



    // @FormUrlEncoded
    //@POST(ApiUtils.BASE_Country)
    //    Call<ProfileActivity>BALANCE_CALL(@Field("id")int id, @Field("country_name_fr") String countrynamefr, @Field("country_status") String countrystatus);


}
