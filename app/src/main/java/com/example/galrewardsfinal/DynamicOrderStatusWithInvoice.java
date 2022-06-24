package com.example.galrewardsfinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

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

public class DynamicOrderStatusWithInvoice extends AppCompatActivity {

    private RecyclerView OrderInvoiceList;
    private LinearLayoutManager linearLayoutManagerOrderInvoice;
    private DividerItemDecoration dividerItemDecorationOrderInvoice;
    private List<OrderInvoice> OrderInvoiceList1;
    private RecyclerView.Adapter OrderInvoiceAdapter;

    private String url = "http://mygalrewards.com/galrewards/api/view/order?id=ORD00080";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_order_status_with_invoice);

        OrderInvoiceList = findViewById(R.id.main_orderstatuswithinvoice);

        OrderInvoiceList1 = new ArrayList<>();
        OrderInvoiceAdapter = new InvoiceAdapter(getApplicationContext(), OrderInvoiceList1);

        linearLayoutManagerOrderInvoice = new LinearLayoutManager(this);
        linearLayoutManagerOrderInvoice.setOrientation(LinearLayoutManager.VERTICAL);
        dividerItemDecorationOrderInvoice = new DividerItemDecoration(OrderInvoiceList.getContext(), linearLayoutManagerOrderInvoice.getOrientation());

        OrderInvoiceList.setHasFixedSize(true);
        OrderInvoiceList.setLayoutManager(linearLayoutManagerOrderInvoice);
        OrderInvoiceList.addItemDecoration(dividerItemDecorationOrderInvoice);
        OrderInvoiceList.setAdapter(OrderInvoiceAdapter);

        getInvoiceData();

    }

    private void getInvoiceData() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();


        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new com.android.volley.Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);

                        OrderInvoice orderInvoice = new OrderInvoice();
                        orderInvoice.setProductname(jsonObject.getString("product_name_en"));
                        orderInvoice.setStatus(jsonObject.getString("status"));
                        orderInvoice.setInvoiceno(jsonObject.getString("invoice_no"));
                        orderInvoice.setPoints(jsonObject.getInt("points"));
                        orderInvoice.setQty(jsonObject.getInt("product_qty"));
                        orderInvoice.setSubtotal(jsonObject.getInt("subtotal"));
                        orderInvoice.setInvoimg(jsonObject.getString("product_thambnailnew"));

                        // ticketlist.setTicketdate(jsonObject.getInt("ticket_date"));

                        //   ticketList.setView(jsonObject.getString(""));

                        OrderInvoiceList1.add(orderInvoice);
                    } catch (JSONException e) {
                        e.printStackTrace();
                        progressDialog.dismiss();
                    }
                }
                OrderInvoiceAdapter.notifyDataSetChanged();
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