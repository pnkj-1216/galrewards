package com.example.galrewardsfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class NewDynamicHomePage extends AppCompatActivity {
    ImageView menu,cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_dynamic_home_page);

        menu = (ImageView) findViewById(R.id.dynamicmenuhome);
        cart = (ImageView) findViewById(R.id.dynamiccarthome);

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewDynamicHomePage.this,CartActivity.class);
                startActivity(intent);
            }
        });
    }
}