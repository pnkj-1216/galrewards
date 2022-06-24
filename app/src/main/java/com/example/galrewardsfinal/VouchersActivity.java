package com.example.galrewardsfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class VouchersActivity extends AppCompatActivity {
    Button btnvoucher1,btnvoucher2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vouchers);

        btnvoucher1 = (Button) findViewById(R.id.btnaddcartevoucher);
        btnvoucher2 = (Button) findViewById(R.id.btnaddcartevoucher2);
        final int[] count = {0};

        btnvoucher1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Intent intent = new Intent(VouchersActivity.this,CartActivity.class);
               // startActivity(intent);
                Toast.makeText(VouchersActivity.this, "Successfully Add To Cart ",Toast.LENGTH_SHORT).show();
            }
        });


        btnvoucher2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VouchersActivity.this,CartActivity.class);
                startActivity(intent);
                Toast.makeText(VouchersActivity.this, "Successfully Add To Cart ",Toast.LENGTH_SHORT).show();

            }
        });
    }}
