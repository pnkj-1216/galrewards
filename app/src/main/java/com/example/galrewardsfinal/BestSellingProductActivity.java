package com.example.galrewardsfinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Display;
import android.view.GestureDetector;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

//import uk.co.senab.photoview.PhotoViewAttacher;

public class BestSellingProductActivity extends AppCompatActivity {

    private String urlbest = "http://mygalrewards.com/galrewards/api/productspecial/?id=en&country=India";
    private RecyclerView mListDeal;
    private LinearLayoutManager linearLayoutManager;
    private DividerItemDecoration dividerItemDecoration;
    private List<BestDeal> DealList;
    private RecyclerView.Adapter adapter;
   // private PhotoViewAttacher pAttacher;
    private ImageView imgbest;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_best_selling_product);

        mListDeal = findViewById(R.id.idRVItems);
      //  pAttacher = new PhotoViewAttacher(imgbest);

      //  pAttacher.update();

        DealList = new ArrayList<>();
        adapter = new BestDealAdapter(getApplicationContext(),DealList);

        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        dividerItemDecoration = new DividerItemDecoration(mListDeal.getContext(), linearLayoutManager.getOrientation());

        mListDeal.setHasFixedSize(true);
        mListDeal.setLayoutManager(linearLayoutManager);
        mListDeal.addItemDecoration(dividerItemDecoration);
        mListDeal.setAdapter(adapter);

        getData();

        ActionBar actionBar = getSupportActionBar();

        // Customize the back button
        actionBar.setHomeAsUpIndicator(R.drawable.mybutton);

        // showing the back button in action bar
        actionBar.setDisplayHomeAsUpEnabled(true);
    }



    // this event will enable the back
    // function to the button on press
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


       /* Integer img = R.drawable.images;
        int NUMBER_OF_IMAGES = 2;
        for(int i = 0; i < NUMBER_OF_IMAGES; i++) {
            ImageView iView = new ImageView(this);
            iView.setImageResource(img);

            linearLayoutManager.addView(iView);
        }*/

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(urlbest, new com.android.volley.Response.Listener<JSONArray>() {
           // private long selectedImageUri;

            @Override
            public void onResponse(JSONArray response) {

                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);

                        BestDeal bestDeal = new BestDeal();
                        bestDeal.setProductname(jsonObject.getString("product_name_en"));
                        bestDeal.setPoints(jsonObject.getInt("points"));
                        bestDeal.setImg(jsonObject.getString("product_thambnailnew"));
                        //DealList.add(new BestDeal());


                        DealList.add(bestDeal);
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


}

