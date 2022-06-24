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
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MyTicketList extends AppCompatActivity {
    Button btnticktview;
    private RecyclerView ticketlist;

    private LinearLayoutManager linearLayoutManagerticket;
    private DividerItemDecoration dividerItemDecorationticket;
    private List<TicketList> ticketList1;
    private RecyclerView.Adapter ticketadapter;

    private String url = "http://mygalrewards.com/galrewards/api/ticket_list?user_id=77";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_ticket_list);

        btnticktview = (Button) findViewById(R.id.btnTicktview);


       // ticketview.setOnClickListener(new AdapterView.OnItemClickListener() {
                                       //   @Override
                                        //  public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                              // ticketview tic =

                                         // }


                                     // });
              //  load_page();



        ticketlist = findViewById(R.id.main_ticketlist);

        ticketList1 = new ArrayList<>();
        ticketadapter = new TicketListAdapter(getApplicationContext(), ticketList1);

        linearLayoutManagerticket = new LinearLayoutManager(this);
        linearLayoutManagerticket.setOrientation(LinearLayoutManager.VERTICAL);
        dividerItemDecorationticket = new DividerItemDecoration(ticketlist.getContext(), linearLayoutManagerticket.getOrientation());

        ticketlist.setHasFixedSize(true);
        ticketlist.setLayoutManager(linearLayoutManagerticket);
        ticketlist.addItemDecoration(dividerItemDecorationticket);
        ticketlist.setAdapter(ticketadapter);

        getData();
       // load_page();
    }

   // private void load_page() {

   // }
/*
    private void load_page() {

        String url = "http://mygalrewards.com/galrewards/api/ticket_list?user_id=77";
        TextView textView = findViewById(R.id.ticktview);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String answer = response.getString("title");
                            textView.setText(answer);
                        } catch (JSONException e) {
                            Toast.makeText(getApplicationContext(), "something went wrong", Toast.LENGTH_LONG).show();
                            Log.d("scuess", "onResponse: ");

                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error
                    }
                });

       // requestQueue.add(jsonObjectRequest);

    }

 */


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

                        TicketList ticketlist = new TicketList();
                        ticketlist.setNeedassistance(jsonObject.getString("need_assistance"));
                        ticketlist.setComment(jsonObject.getString("comment"));
                        ticketlist.setStatus(jsonObject.getString("status"));
                        // ticketlist.setTicketdate(jsonObject.getInt("ticket_date"));

                        //   ticketList.setView(jsonObject.getString(""));

                        ticketList1.add(ticketlist);
                    } catch (JSONException e) {
                        e.printStackTrace();
                        progressDialog.dismiss();
                    }
                }
                ticketadapter.notifyDataSetChanged();
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