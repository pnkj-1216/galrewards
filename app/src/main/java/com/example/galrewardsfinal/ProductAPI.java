package com.example.galrewardsfinal;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Path;

public class ProductAPI {

    @DELETE("product/delete/{id}")
    Call<Void> delete(@Path("id") int id,int id1,int id2,int id3) {
        return null;
    }
}
