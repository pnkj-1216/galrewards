package com.example.galrewardsfinal;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Adapter;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
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

public class RevolvingImageActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Revolving> revolving;
    private static String JSON_URL = "http://mygalrewards.com/galrewards/api/revol/image/?id=en";
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_revolving_image);


        recyclerView = findViewById(R.id.revolvinglist);
        revolving = new ArrayList<>();
        extractSongs();

    }

    private void extractSongs() {
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, JSON_URL, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject songObject = response.getJSONObject(i);
                        Revolving rev = new Revolving();
                        rev.setTitle(songObject.getString("title_en").toString());
                        rev.setArtists(songObject.getString("description_en").toString());
                        rev.setSongUrl(songObject.getString("image"));

                        revolving.add(rev);


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
               // adapter = new Adapter(getApplicationContext(),revolving);
                //recyclerView.setAdapter(adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("tag","onErrorResponse: " + error.getMessage());

            }
        });

        queue.add(jsonArrayRequest);
    }
}