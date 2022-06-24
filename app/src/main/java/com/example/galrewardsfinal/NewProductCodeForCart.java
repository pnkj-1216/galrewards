package com.example.galrewardsfinal;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewProductCodeForCart extends AppCompatActivity {
    private ListView listViewProduct;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_product_code_for_cart);

        listViewProduct = findViewById(R.id.listviewproduct);

        loadData();
    }

    private void loadData() {

        try {
            ProductService productService = ApiClientProduct.getClient().create(ProductService.class);
            Call call = productService.en();
            call.enqueue(new Callback() {
                @Override
                public void onResponse(Call call, Response response) {
                    List<ProductNew> productsNew = (List<ProductNew>) response.body();
                    ProductListAdapter productListAdapter = new ProductListAdapter(getApplicationContext(),productsNew);
                    listViewProduct.setAdapter(productListAdapter);


                }

                @Override
                public void onFailure(Call call, Throwable t) {
                    Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_SHORT).show();

                }
            });

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }
    }
