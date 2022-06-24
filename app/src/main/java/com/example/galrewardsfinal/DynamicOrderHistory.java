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
import android.widget.Button;
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

public class DynamicOrderHistory extends AppCompatActivity{
    private RecyclerView mList1;
    private LinearLayoutManager linearLayoutManager;
    private DividerItemDecoration dividerItemDecoration;
    private List<Order> movieList1;
    private RecyclerView.Adapter adapter;
    private Button mBtninvoice;

    private String url = "http://mygalrewards.com/galrewards/api/order/view/?email=vijaykashyap265@gmail.com";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_order_history);

        mList1 = findViewById(R.id.main_list1);
        mBtninvoice =(Button) findViewById(R.id.btnorderviewforinvoicedetail);



       /* mBtninvoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DynamicOrderHistory.this,DynamicOrderStatusWithInvoice.class);
                startActivity(intent);
            }
        });
        */

        movieList1 = new ArrayList<>();
        adapter = new OrderAdapter(getApplicationContext(), movieList1);

        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        dividerItemDecoration = new DividerItemDecoration(mList1.getContext(), linearLayoutManager.getOrientation());

        mList1.setHasFixedSize(true);
        mList1.setLayoutManager(linearLayoutManager);
        mList1.addItemDecoration(dividerItemDecoration);
        mList1.setAdapter(adapter);

      //vija  button = findViewById(R.id.btnorderviewforinvoicedetail);

/*      mBtninvoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               openactivity();
            }
        });
*/



        getData();
        getView();



        ActionBar actionBar = getSupportActionBar();

        // Customize the back button
        actionBar.setHomeAsUpIndicator(R.drawable.mybutton);

        // showing the back button in action bar
        actionBar.setDisplayHomeAsUpEnabled(true);
    }


    // private void openactivity() {

   // }


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


        //Intent intent = new Intent(getApplicationContext(),DynamicOrderStatusWithInvoice.class);
       // startActivity(intent);


        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new com.android.volley.Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);

                        Order order = new Order();
                        order.setInvoiceno(jsonObject.getString("invoice_no"));
                        order.setPoints(jsonObject.getInt("points"));
                        order.setStatusinv(jsonObject.getString("status"));

                        movieList1.add(order);
                    } catch (JSONException e)
                    {
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


/*


*/





    }

    private void getView() {
        Intent in = new Intent(getApplicationContext(),DynamicOrderStatusWithInvoice.class);
        startActivity(in);
    }




}