package com.example.galrewardsfinal;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.BuildConfig;

import android.content.ClipData;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;

public class CartActivity extends AppCompatActivity{

    //private TableLayout tableLayout;
    //private Button buttonContinueShopping;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        setTitle(R.string.cart_Pagen);}}
        /*

        tableLayout = (TableLayout)findViewById(R.id.tableLayoutProduct);
        buttonContinueShopping = (Button)findViewById(R.id.buttonContinueShopping);

        buttonContinueShopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CartActivity.this,NewProductCodeForCart.class);
                startActivity(intent);
            }
        });

        //loadData();
        addCart();
        //createColumns();
        fillData();
    }

    private void addCart(){
        try {
            Intent intent = getIntent();
            ProductNew productNew = (ProductNew) intent.getSerializableExtra("en");
            if(!Cart.isExists(productNew)){
                Cart.insert(new Item(productNew,1));
            }
            else {
                Cart.update(productNew);
            }
            Cart.insert(new Item(productNew,1));

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
        }

    }

    private void createColumns(){
        TableRow tableRow = new TableRow(this);
        tableRow.setLayoutParams(new TableRow.LayoutParams(
                TableRow.LayoutParams.FILL_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT
        ));

        //ID Column

        TextView textViewId = new TextView(this);
        textViewId.setText("id");
        textViewId.setTypeface(Typeface.DEFAULT,Typeface.BOLD);
        textViewId.setPadding(5,5,5,0);
        tableRow.addView(textViewId);

        //Name Column

        TextView textViewName = new TextView(this);
        textViewName.setText("product_name_en");
        textViewName.setTypeface(Typeface.DEFAULT,Typeface.BOLD);
        textViewName.setPadding(5,5,5,0);
        tableRow.addView(textViewName);

        //Photo Column

        TextView textViewPhoto = new TextView(this);
        textViewPhoto.setText("product_thambnail");
        textViewPhoto.setTypeface(Typeface.DEFAULT,Typeface.BOLD);
        textViewPhoto.setPadding(5,5,5,0);
        tableRow.addView(textViewPhoto);

        //Price Column

        TextView textViewPrice = new TextView(this);
        textViewPrice.setText("points");
        textViewPrice.setTypeface(Typeface.DEFAULT,Typeface.BOLD);
        textViewPrice.setPadding(5,5,5,0);
        tableRow.addView(textViewPrice);

        //Quantity Column

        TextView textViewQuantity = new TextView(this);
        textViewQuantity.setText("quantity");
        textViewQuantity.setTypeface(Typeface.DEFAULT,Typeface.BOLD);
        textViewQuantity.setPadding(5,5,5,0);
        tableRow.addView(textViewQuantity);

        //SubTotalColumn

        TextView textViewSubTotal = new TextView(this);
        textViewSubTotal.setText("Sub Total");
        textViewSubTotal.setTypeface(Typeface.DEFAULT,Typeface.BOLD);
        textViewSubTotal.setPadding(5,5,5,0);
        tableRow.addView(textViewSubTotal);

        tableLayout.addView(tableLayout,new TableLayout.LayoutParams(
                TableRow.LayoutParams.FILL_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT));

        //Add Divider

        tableRow = new TableRow(this);
        tableRow.setLayoutParams(new TableRow.LayoutParams(
                TableRow.LayoutParams.FILL_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT));

        //Option Column

        TextView textViewOption = new TextView(this);
        textViewOption.setText("Option");
        textViewOption.setTypeface(Typeface.DEFAULT,Typeface.BOLD);
        textViewOption.setPadding(5,5,5,0);
        tableRow.addView(textViewOption);


        //Id Column

        textViewId = new TextView(this);
        textViewId.setText("----");
        textViewId.setTypeface(Typeface.DEFAULT,Typeface.BOLD);
        textViewId.setPadding(5,5,5,0);
        tableRow.addView(textViewId);

        //Name Column

        textViewName = new TextView(this);
        textViewName.setText("------------");
        textViewName.setTypeface(Typeface.DEFAULT,Typeface.BOLD);
        textViewName.setPadding(5,5,5,0);
        tableRow.addView(textViewName);

        //Price Column

        textViewPrice = new TextView(this);
        textViewPrice.setText("-------");
        textViewPrice.setTypeface(Typeface.DEFAULT,Typeface.BOLD);
        textViewPrice.setPadding(5,5,5,0);
        tableRow.addView(textViewPrice);

        //Photo Column

        textViewPhoto = new TextView(this);
        textViewPhoto.setText("-------");
        textViewPhoto.setTypeface(Typeface.DEFAULT,Typeface.BOLD);
        textViewPhoto.setPadding(5,5,5,0);
        tableRow.addView(textViewPhoto);

        textViewPhoto = new TextView(this);
        textViewPhoto.setText("-------");
        textViewPhoto.setTypeface(Typeface.DEFAULT,Typeface.BOLD);
        textViewPhoto.setPadding(5,5,5,0);
        tableRow.addView(textViewPhoto);

        textViewPhoto = new TextView(this);
        textViewPhoto.setText("-------");
        textViewPhoto.setTypeface(Typeface.DEFAULT,Typeface.BOLD);
        textViewPhoto.setPadding(5,5,5,0);
        tableRow.addView(textViewPhoto);


        tableLayout.addView(tableRow,new TableLayout.LayoutParams(
                TableRow.LayoutParams.FILL_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT));
    }

    private void fillData(){
        try{
            for(Item item : Cart.contents() ){

                TableRow tableRow = new TableRow(this);
                tableRow.setLayoutParams(new TableRow.LayoutParams(
                        TableRow.LayoutParams.FILL_PARENT,
                        TableRow.LayoutParams.WRAP_CONTENT));

                //Option column
                ImageButton imageButtonOption = new ImageButton(this);
                imageButtonOption.setImageResource(R.drawable.delete);
                imageButtonOption.setPadding(5,5,5,0);
                imageButtonOption.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //  Toast.makeText(getApplicationContext(),item.getProduct().getName(),Toast.LENGTH_SHORT).show();
                        AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                        builder.setTitle("Confirm");
                        builder.setMessage("Are You Sure");
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Cart.remove(item.getProductNew());
                                tableLayout.removeAllViews();
                                createColumns();
                                fillData();

                            }
                        });
                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int which) {
                                dialogInterface.cancel();

                            }
                        });
                        builder.show();
                    }
                });
                tableRow.addView(imageButtonOption);

                //Id Column

                TextView textViewId = new TextView(this);
                textViewId.setText(String.valueOf(item.getProductNew().getId()));
                textViewId.setTypeface(Typeface.DEFAULT,Typeface.BOLD);
                textViewId.setPadding(5,5,5,0);
                tableRow.addView(textViewId);

                //Name Column

                TextView textViewName = new TextView(this);
                textViewName.setText(item.getProductNew().getName());
                textViewName.setTypeface(Typeface.DEFAULT,Typeface.BOLD);
                textViewName.setPadding(5,5,5,0);
                tableRow.addView(textViewName);

                //Photo Column

                ImageView imageViewPhoto = new ImageView(this);
                Bitmap bitmap = new ImageRequestAsk().execute(item.getProductNew().getPhoto()).get();
                imageViewPhoto.setImageBitmap(bitmap);
                imageViewPhoto.setScaleType(ImageView.ScaleType.CENTER);
                imageViewPhoto.setPadding(5,5,5,5);
                tableRow.addView(imageViewPhoto);



                //Price Column

                TextView textViewPrice = new TextView(this);
                textViewPrice.setText(String.valueOf(item.getProductNew().getPrice()));
                textViewPrice.setTypeface(Typeface.DEFAULT,Typeface.BOLD);
                textViewPrice.setPadding(5,5,5,0);
                tableRow.addView(textViewPrice);

                //Quantity Column

                TextView textViewQuantity = new TextView(this);
                textViewQuantity.setText(String.valueOf(item.getQuantity()));
                textViewQuantity.setTypeface(Typeface.DEFAULT,Typeface.BOLD);
                textViewQuantity.setPadding(5,5,5,0);
                tableRow.addView(textViewQuantity);

                //Sub Total Column

                TextView textViewSubTotal = new TextView(this);
                textViewSubTotal.setText(String.valueOf(item.getProductNew().getPrice()*item.getQuantity()));
                textViewSubTotal.setTypeface(Typeface.DEFAULT,Typeface.BOLD);
                textViewSubTotal.setPadding(5,5,5,0);
                tableRow.addView(textViewSubTotal);

                tableLayout.addView(tableRow,new TableLayout.LayoutParams(
                        TableRow.LayoutParams.FILL_PARENT,
                        TableRow.LayoutParams.WRAP_CONTENT));
            }

            //Add Total Row

            TableRow tableRowTotal = new TableRow(this);
            tableRowTotal.setLayoutParams(new TableRow.LayoutParams(
                    TableRow.LayoutParams.FILL_PARENT,
                    TableRow.LayoutParams.WRAP_CONTENT));

            TextView textViewTotal = new TextView(this);
            textViewTotal.setText("Total");
            textViewTotal.setTypeface(Typeface.DEFAULT,Typeface.BOLD);
            textViewTotal.setPadding(5,5,5,0);
            tableRowTotal.addView(textViewTotal);

            TextView textViewTotalValue = new TextView(this);
            textViewTotalValue.setText(String.valueOf(Cart.total()));
            textViewTotalValue.setTypeface(Typeface.DEFAULT,Typeface.BOLD);
            textViewTotalValue.setPadding(5,5,5,0);
            tableRowTotal.addView(textViewTotalValue);

            tableLayout.addView(tableRowTotal,new TableLayout.LayoutParams(
                    TableRow.LayoutParams.FILL_PARENT,
                    TableRow.LayoutParams.WRAP_CONTENT));

        } catch (Exception e2) {
            Toast.makeText(getApplicationContext(),e2.getMessage(),Toast.LENGTH_LONG).show();
        }
    }

    private class ImageRequestAsk extends AsyncTask<String ,Void,Bitmap> {

        @Override
        protected Bitmap doInBackground(String... params) {
            try {
                InputStream inputStream = new java.net.URL(params[0]).openStream();
                return BitmapFactory.decodeStream(inputStream);

            } catch (Exception e) {
                return null;
            }
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
        }
    }

    private class ImageHttpRequest {}}*/