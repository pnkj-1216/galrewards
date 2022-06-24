package com.example.galrewardsfinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

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
import java.util.Observable;
import java.util.function.Consumer;

import retrofit2.Retrofit;

public class TicketView extends AppCompatActivity {
    //Button ticketview;
    private RecyclerView ticketlistview;

    private LinearLayoutManager linearLayoutManagerticketview;
    private DividerItemDecoration dividerItemDecorationticketview;
    private List<TicketViewDetail> ticketViewDetail1;
    private RecyclerView.Adapter ticketdetailadapter;

    private String url = "http://mygalrewards.com/galrewards/api/ticket_view?id=97";


    TextView receiver_msg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_view);

        receiver_msg = (TextView) findViewById(R.id.received_value_id);


        Intent intent = getIntent();


        String str = intent.getStringExtra("message_key");
        String str1 = intent.getStringExtra("message_key");
        String str2 = intent.getStringExtra("message_key");

        receiver_msg.setText(str);


        ticketlistview = findViewById(R.id.main_ticketlistdetail);

        ticketViewDetail1 = new ArrayList<>();
        ticketdetailadapter = new TicketViewDetailAdapter(getApplicationContext(), ticketViewDetail1);

        linearLayoutManagerticketview = new LinearLayoutManager(this);
        linearLayoutManagerticketview.setOrientation(LinearLayoutManager.VERTICAL);
        dividerItemDecorationticketview = new DividerItemDecoration(ticketlistview.getContext(), linearLayoutManagerticketview.getOrientation());

        ticketlistview.setHasFixedSize(true);
        ticketlistview.setLayoutManager(linearLayoutManagerticketview);
        ticketlistview.addItemDecoration(dividerItemDecorationticketview);
        ticketlistview.setAdapter(ticketdetailadapter);

        getData();



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

                        TicketViewDetail ticketViewDetail = new TicketViewDetail();
                        ticketViewDetail.setNedassistance(jsonObject.getString("need_assistance"));
                        ticketViewDetail.setComent(jsonObject.getString("comment"));
                        ticketViewDetail.setStaus(jsonObject.getString("status"));
                        ticketViewDetail.setDte(jsonObject.getString("ticket_date"));

                        // ticketlist.setTicketdate(jsonObject.getInt("ticket_date"));
                        // ticketList.setView(jsonObject.getString(""));

                        ticketViewDetail1.add(ticketViewDetail);
                    } catch (JSONException e) {
                        e.printStackTrace();
                        progressDialog.dismiss();
                    }
                }
                ticketdetailadapter.notifyDataSetChanged();
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

        //Code for Back Arrow


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




}