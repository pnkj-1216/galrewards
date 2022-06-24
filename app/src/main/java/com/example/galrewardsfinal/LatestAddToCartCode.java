package com.example.galrewardsfinal;

import static com.example.galrewardsfinal.ProductAdapterNew.cartModels;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import static com.example.galrewardsfinal.ProductAdapterNew.cartModels;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;

import retrofit2.Call;
import retrofit2.Callback;

public class LatestAddToCartCode extends AppCompatActivity {




    private RecyclerView cartList1;

    private LinearLayoutManager linearLayoutManager;
    private DividerItemDecoration dividerItemDecoration;
    private List<Cart> cartList;
    private RecyclerView.Adapter adapter;
    private TextView btnremove;
    EditText pcartname,pcartpoint,pcartqty,pcarttotal;

    private String url  = "http://mygalrewards.com/galrewards/api/cart_view?user_id=77";
    private String url2 = "http://mygalrewards.com/galrewards/api/dcart_item/item_id";
    private String urlmain = url2+"item_id";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_latest_add_to_cart_code);

        btnremove = (TextView)findViewById(R.id.productremove);
        
        initView();

        cartList1 = findViewById(R.id.recycler_view_cart);

        cartList = new ArrayList<>();
        adapter = new CartAdapter(getApplicationContext(), cartList);

        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        dividerItemDecoration = new DividerItemDecoration(cartList1.getContext(), linearLayoutManager.getOrientation());

        cartList1.setHasFixedSize(true);
        cartList1.setLayoutManager(linearLayoutManager);
        cartList1.addItemDecoration(dividerItemDecoration);
        cartList1.setAdapter(adapter);

        //vija  button = findViewById(R.id.btnorderviewforinvoicedetail);

        RequestQueue queue = Volley.newRequestQueue(this);

        getData();



        ActionBar actionBar = getSupportActionBar();

        // Customize the back button
        actionBar.setHomeAsUpIndicator(R.drawable.mybutton);

        // showing the back button in action bar
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    private void initView() {
        pcartname = findViewById(R.id.main_cartproname);
        pcartpoint = findViewById(R.id.main_cartpropoint);
        pcartqty = findViewById(R.id.main_cartprostatus);
        pcarttotal = findViewById(R.id.main_cartprototal);
        btnremove = findViewById(R.id.productremove);

//        btnremove.setOnClickListener(new View.OnClickListener() {
        //  @Override
        //  public void onClick(View v) {
        //removeproduct();
        // }
        //});

//        btnremove.setOnClickListener(new View.OnClickListener() {
        //  @Override
        //  public void onClick(View view) {
        //       buttonDelete_onClick(view);
        //  }
        // });


        //private void removeproduct() {

        StringRequest stringRequest = new StringRequest(Request.Method.DELETE,
                url2,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        btnremove.setText("Response is: " + response.substring(0,500));
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                btnremove.setText("Not Delete");
            }
        }
        );

      //  RequestQueue queue = Volley.newRequestQueue(this);
       // queue.add(stringRequest);
    }
   // }

    //private void buttonDelete_onClick(View view) {

     /*   JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.DELETE, url2, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    String productidcartremove = response.getString("item_id");

                  //  productidcartremove.setItemRemove(itemremove);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(LatestAddToCartCode.this,"Cant Delete..",Toast.LENGTH_SHORT).show();
            }
        });

*/

//}


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


        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new com.android.volley.Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);

                        Cart cart = new Cart();
                        cart.setPcartname(jsonObject.getString("product_name_en"));
                        cart.setCartpoints(jsonObject.getInt("point"));
                        cart.setCarttotal(jsonObject.getInt("total_point"));
                        cart.setProcartstatus(jsonObject.getInt("quantity"));
                        cart.setPcartimg(jsonObject.getString("product_thambnailnew"));

                        cartList.add(cart);
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

    }}


//Old Code
        /*
        context = this;
        temparraylist = new ArrayList<>();
        mToolbarnew = (Toolbar) findViewById(R.id.toolbarnew);
        proceedToBook = findViewById(R.id.proceed_to_book);
        grandTotal = findViewById(R.id.grand_total_cart);
        setSupportActionBar(mToolbarnew);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Cart");
        mToolbarnew.setNavigationIcon(getResources().getDrawable(R.drawable.ic_back_arrow_));
        mToolbarnew.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // these lines of code for show the same  cart for future refrence
                grandTotalplus = 0;
                for (int i = 0; i < temparraylist.size(); i++)
                { }
                cartModels.addAll(temparraylist);
                LatestProductCode.cart_count = (temparraylist.size());
//                addItemInCart.clear();
                finish();
            }
        });
        LatestProductCode.cart_count = 0;

        //addInCart();

        Log.d("sizecart_1", String.valueOf(temparraylist.size()));
        Log.d("sizecart_2", String.valueOf(cartModels.size()));

        // from these lines of code we remove the duplicacy of cart and set last added quantity in cart
        // for replace same item
        for (int i = 0; i < cartModels.size(); i++) {
            for (int j = i + 1; j < cartModels.size(); j++)
            {
                if (cartModels.get(i).getProductImage().equals(cartModels.get(j).getProductImage()))
                {
                    cartModels.get(i).setProductQuantity(cartModels.get(j).getProductQuantity());
                    cartModels.get(i).setTotalCash(cartModels.get(j).getTotalCash());
                    cartModels.remove(j);
                    j--;
                    Log.d("remove", String.valueOf(cartModels.size()));
                }
            }
        }
        temparraylist.addAll(cartModels);
        cartModels.clear();
        Log.d("sizecart_11", String.valueOf(temparraylist.size()));
        Log.d("sizecart_22", String.valueOf(cartModels.size()));
        // this code is for get total cash
        for (int i = 0; i < temparraylist.size(); i++)
        {
            grandTotalplus = grandTotalplus + temparraylist.get(i).getTotalCash();
        }

        grandTotal.setText("Rs." + String.valueOf(grandTotalplus));
        cartRecyclerView = findViewById(R.id.recycler_view_cart);
        cartAdapter = new CartAdapter(temparraylist, this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        cartRecyclerView.setLayoutManager(mLayoutManager);
        cartRecyclerView.setAdapter(cartAdapter);

        proceedToBook.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //Toast.makeText(CartActivity.this, "order placed", Toast.LENGTH_SHORT).show();
                //bookMyOrder();
            }
        });
    }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        grandTotalplus = 0;
        for (int i = 0; i < temparraylist.size(); i++)
        {
            LatestProductCode.cart_count = (temparraylist.size());
        }
        cartModels.addAll(temparraylist);
        //cartModels.clear();
    }
}*/