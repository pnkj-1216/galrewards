package com.example.galrewardsfinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.appyvet.materialrangebar.IRangeBarFormatter;
import com.appyvet.materialrangebar.RangeBar;
import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class DynamicCategory extends AppCompatActivity implements Callback<Category>{

    private String url = "http://mygalrewards.com/galrewards/api/product/?id=en&country=India";
    private String Baseurl= "http://mygalrewards.com/galrewards/";
    private RecyclerView mList;
    private LinearLayoutManager linearLayoutManager;
    private DividerItemDecoration dividerItemDecoration;
    private List<Category> movieList;
    private RecyclerView.Adapter adapter;
    Button orderbuy;
    ImageView imgview;
    private View context;

    static int mLeftValue = 10000;
    static int mRightValue = 300000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_category);

        //Range COde

      /* */

        mList = findViewById(R.id.recyclerViewproduct);
        orderbuy = (Button) findViewById(R.id.btnbuynowproduct);
        ImageView imageView = findViewById(R.id.main_imgpro);
        movieList = new ArrayList<>();
        adapter = new CategoryAdapter(getApplicationContext(), movieList);

        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        dividerItemDecoration = new DividerItemDecoration(mList.getContext(), linearLayoutManager.getOrientation());

        mList.setHasFixedSize(true);
        mList.setLayoutManager(linearLayoutManager);
        mList.addItemDecoration(dividerItemDecoration);
        mList.setAdapter(adapter);

        getData();

//Customize the back button
        ActionBar actionBar = getSupportActionBar();
        // Customize the back button
        actionBar.setHomeAsUpIndicator(R.drawable.mybutton);
        // showing the back button in action bar
        actionBar.setDisplayHomeAsUpEnabled(true);

        //Range Bar Code
/*

        public static void materialRangeDialog(final Context ctx, final String message, final DialogCallback dialogCallback,
        boolean isCancalable) {
            boolean wrapInScrollView = false;
            final MaterialDialog dialog = new
                    MaterialDialog.Builder(ctx).customView(R.layout.product_item, wrapInScrollView)
                    .backgroundColorRes(android.R.color.transparent).build();
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
            View dialogView = dialog.getView();
            RangeBar rangebar = (RangeBar) dialogView.findViewById(R.id.rangebar);
            rangebar.setFormatter(new IRangeBarFormatter() {
                @Override
                public String format(String s) {
                    int data = Integer.valueOf(s);
                    int updatedValue =  data * 10000;
                    return String.valueOf(updatedValue);
                }
            });
            rangebar.setOnRangeBarChangeListener(new RangeBar.OnRangeBarChangeListener() {
                @Override
                public void onRangeChangeListener(RangeBar rangeBar, int leftPinIndex,
                                                  int rightPinIndex, String leftPinValue, String rightPinValue) {
                    mLeftValue = Integer.valueOf(leftPinValue) * 10000;
                    mRightValue = Integer.valueOf(rightPinValue) * 10000;
                }

            });

            Button cancelButton = (Button) dialogView.findViewById(R.id.cancel_button);
            Button doneButton = (Button) dialogView.findViewById(R.id.done_button);
            dialog.setCancelable(isCancalable);
            dialog.show();
            cancelButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialogCallback.onCancel();
                    dialog.dismiss();
                }
            });
            doneButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialogCallback.onDane(String.valueOf(mLeftValue), String.valueOf(mRightValue));
                    dialog.dismiss();
                }
            });
        }


*/


/*
        Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(OrderPlace.URL_BASE)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        OrderPlace orderPlace = retrofit.create(OrderPlace.class);

            try {
                JSONObject paramObject = new JSONObject();
                paramObject.put("product_id", "1");
                paramObject.put("product_qty", "1");
                paramObject.put("points", "100");
                paramObject.put("email", "vijaykashyap265@gmail.com");
                paramObject.put("subtotal", "200");
                paramObject.put("id","32");
                Call<Category> categoryCall = orderPlace.getTitle(paramObject.toString());
                categoryCall.enqueue(this);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

        private void order() {
         }
*/
        // this event will enable the back
        // function to the button on press
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);

    }

    private void getData() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new com.android.volley.Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);

                        Category category = new Category();
                        category.setTitle(jsonObject.getString("product_name_en"));
                        category.setRating(jsonObject.getInt("points"));
                        category.setIdpro(jsonObject.getInt("id"));
                        //movie.setYear(jsonObject.getInt("special_deals"));
                        //movie.setId(jsonObject.getInt("id"));
                        category.setCatname(jsonObject.getString("categories_name_en"));
                        category.setCountry(jsonObject.getString("country_id"));
                        category.setImg(jsonObject.getString("product_thambnailnew"));

                        movieList.add(category);
                    } catch (JSONException e) {
                        e.printStackTrace();
                        progressDialog.dismiss();
                    }
                }
                adapter.notifyDataSetChanged();
                progressDialog.dismiss();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Volley", error.toString());
                progressDialog.dismiss();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);

    }

    @Override
    public void onResponse(Call<Category> call, retrofit2.Response<Category> response) {


    }

    @Override
    public void onFailure(Call<Category> call, Throwable t) {

    }
}