package com.example.galrewardsfinal;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
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

public class ProductActivity extends AppCompatActivity {

    private RecyclerView mList;
    private LinearLayoutManager linearLayoutManager;
    private DividerItemDecoration dividerItemDecoration;
    private List<Product> movieList;
    private RecyclerView.Adapter adapter;
    private String url = "http://mygalrewards.com/galrewards/api/cat?id=en&country=india";

    //all categories url
    //private String url = "http://mygalrewards.com/galrewards/api/cat?id=en";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        mList = findViewById(R.id.main_list);

        movieList = new ArrayList<>();
        adapter = new ProductAdapter(getApplicationContext(), movieList);



        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        dividerItemDecoration = new DividerItemDecoration(mList.getContext(), linearLayoutManager.getOrientation());

        mList.setHasFixedSize(true);
        mList.setLayoutManager(linearLayoutManager);
        mList.addItemDecoration(dividerItemDecoration);
        mList.setAdapter(adapter);

        getData();

        ActionBar actionBar = getSupportActionBar();

        // Customize the back button
        actionBar.setHomeAsUpIndicator(R.drawable.mybutton);

        // showing the back button in action bar
        actionBar.setDisplayHomeAsUpEnabled(true);

    }


    private void getData() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);

                        Product product = new Product();
                        product.setCategoriesname(jsonObject.getString("categories_name_en"));
                        product.setId(jsonObject.getInt("id"));
                        product.setImgcat(jsonObject.getString("image"));
                        //product.setCategoriesstatus(jsonObject.getInt("categories_status"));
                       // product.setCatname(jsonObject.getString("categories_name_en"));
                       // product.setCountry(jsonObject.getString("country_name_en"));


                        movieList.add(product);
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

        /*String url = "http://mygalrewards.com/galrewards/api/product/";

        List<Product> catalog = ShoppingCartHelper.getCatalog(getResources());
        final List<Product> cart = ShoppingCartHelper.getCart();

        int productIndex = getIntent().getExtras().getInt(ShoppingCartHelper.PRODUCT_INDEX);
        final Product selectedProduct = catalog.get(productIndex);*/

        // Set the proper image and text
       // ImageView productImageView = (ImageView) findViewById(R.id.ImageViewProduct);
      //  productImageView.setImageDrawable(selectedProduct.productImage);
        //TextView productTitleTextView = (TextView) findViewById(R.id.TextViewProductTitle);
      //  productTitleTextView.setText(selectedProduct.title);
       // TextView productDetailsTextView = (TextView) findViewById(R.id.TextViewProductDetails);
       // productDetailsTextView.setText(selectedProduct.description);

       // Button addToCartButton = (Button) findViewById(R.id.ButtonAddToCart);
      //  addToCartButton.setOnClickListener(new View.OnClickListener() {

          //  @Override
          //  public void onClick(View v) {


              //  cart.add(selectedProduct);
                //finish();
          //  }
      //  });

        // Disable the add to cart button if the item is already in the cart
        //if(cart.contains(selectedProduct)) {
        //    addToCartButton.setEnabled(false);
        //    addToCartButton.setText("Item in Cart");
       // }

