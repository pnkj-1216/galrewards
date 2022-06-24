package com.example.galrewardsfinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class LatestProductCode extends AppCompatActivity implements ProductAdapterNew.CallBackUs, ProductAdapterNew.HomeCallBack {

public static ArrayList<ProductModel> arrayList = new ArrayList<>();
public static int cart_count = 0;
        ProductAdapterNew productAdapterNew;
        RecyclerView productRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_latest_product_code);

        addProduct();
        productAdapterNew = new ProductAdapterNew(arrayList, this, this);
        productRecyclerView = findViewById(R.id.product_recycler_view);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3, LinearLayoutManager.VERTICAL, false);
        productRecyclerView.setLayoutManager(gridLayoutManager);
        productRecyclerView.setAdapter(productAdapterNew);



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
    private void addProduct() {
        ProductModel productModel = new ProductModel("testjan", "350", "20", R.drawable.testjan);
        arrayList.add(productModel);
        ProductModel productModel1 = new ProductModel("testing product", "200", "10", R.drawable.testingproduct);
        arrayList.add(productModel1);
        ProductModel productModel2 = new ProductModel("HD Find face camera", "200030", "10", R.drawable.hd);
        arrayList.add(productModel2);
        ProductModel productModel3 = new ProductModel("Canon EOS 1500D DSLR Camera with 18-55 mm Lens Kit", "350", "20", R.drawable.canon);
        arrayList.add(productModel3);
        ProductModel productModel12 = new ProductModel("testing", "1500", "10", R.drawable.testing);
        arrayList.add(productModel12);
        ProductModel productModel23 = new ProductModel("demo", "1000", "10", R.drawable.demo);
        arrayList.add(productModel23);
        ProductModel productModel4 = new ProductModel("EvoFox Game Box", "80", "20", R.drawable.fox);
        arrayList.add(productModel4);
        ProductModel productModel14 = new ProductModel("Levis - Digital Voucher", "90", "10", R.drawable.levis);
        arrayList.add(productModel14);
        ProductModel productModel25 = new ProductModel("OnePlus Nord 2 5G", "800", "10", R.drawable.oneplusnewupdate);
        arrayList.add(productModel25);
        ProductModel productModel5 = new ProductModel("XX3 Cologne Spray for Men", "90", "20", R.drawable.xxx3);
        arrayList.add(productModel5);
        ProductModel productModel16 = new ProductModel("boAt Airdopes", "40", "10", R.drawable.boat);
        arrayList.add(productModel16);
        ProductModel productModel17 = new ProductModel("(Renewed) Dell Optiplex 380 17 inch", "100", "10", R.drawable.computing);
        arrayList.add(productModel17);
        ProductModel productModel18 = new ProductModel("MSI Bravo 15 Ryzen", "50", "10", R.drawable.orderimgf);
        arrayList.add(productModel18);
        ProductModel productModel19 = new ProductModel("HP 15 Thin And Light 11th Gen Intel Core i5", "60", "10", R.drawable.hp15);
        arrayList.add(productModel19);
        ProductModel productModel20 = new ProductModel("Synqe USB Type Headset", "30", "10", R.drawable.usb);
        arrayList.add(productModel20);
        ProductModel productModel21 = new ProductModel("iBall EarWear Sporty Wireless Bluetooth in Ear Headset with", "10", "10", R.drawable.iball);
        arrayList.add(productModel21);
    }
    @Override
    public void addCartItemView() {
        //addItemToCartMethod();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem menuItem = menu.findItem(R.id.cart_action);
        menuItem.setIcon(Converter.convertLayoutToImage(LatestProductCode.this, cart_count, R.drawable.ic_shopping_cart_white_24dp));
        return true;


    }
   // @Override
    public boolean onOptionsItemSelectedd(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        switch (item.getItemId()) {
            case R.id.cart_action:
                if (cart_count < 1) {
                    Toast.makeText(this, "there is no item in cart", Toast.LENGTH_SHORT).show();
                } else {
                    startActivity(new Intent(this, LatestAddToCartCode.class));
                }
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;


    }
    @Override
    public void updateCartCount(Context context) {
        invalidateOptionsMenu();
    }
    @Override
    protected void onStart() {
        super.onStart();
        invalidateOptionsMenu();


    }
}