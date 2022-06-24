package com.example.galrewardsfinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class AccountBalance extends AppCompatActivity {

    private TextView bonuspointac, pointac, orderpointac,closingbalanceac;

    //Local Url
    /*String url = "http://mygalrewards.com/galrewards/api/account/balance/?guserid=MG565-BH12";
    String url1 = "http://mygalrewards.com/galrewards/api/account/balance/?guserid=MG565-BH12&ac_date=2021-11";*/


    String url = "http://mygalrewards.com/galrewards/api/account/balance/?guserid=MG565-BH12";
    String url1 = "http://mygalrewards.com/galrewards/api/account/balance/?guserid=MG565-BH12&ac_date=2021-11";

    //Date Picker Code

    EditText date;
    DatePickerDialog datePickerDialog;
    Button btndetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_balance);

        ActionBar actionBar = getSupportActionBar();

        // Customize the back button
        actionBar.setHomeAsUpIndicator(R.drawable.mybutton);

        // showing the back button in action bar
        actionBar.setDisplayHomeAsUpEnabled(true);

        //Date Picker

        date = (EditText) findViewById(R.id.date);

        // initializing our variables.
        bonuspointac = findViewById(R.id.idAccountBonusPoint);
        pointac = findViewById(R.id.idAccountPoint);
        orderpointac = findViewById(R.id.idAccountOrderPoint);
        closingbalanceac = findViewById(R.id.idAccountClosingBalance);

        btndetail = findViewById(R.id.btndetailaccount);
        RequestQueue queue = Volley.newRequestQueue(AccountBalance.this);

        accountsummary();

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
             try {
                   String bonusPoint = response.getString("bonus_point");
                    String Point = response.getString("points");
                    String orderPoint = response.getString("Order_point");
                    String closingBalance = response.getString("closing_bal");

                    bonuspointac.setText(bonusPoint);
                    pointac.setText(Point);
                    orderpointac.setText(orderPoint);
                    closingbalanceac.setText(closingBalance);

             } catch (JSONException e) {

                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
             @Override
            public void onErrorResponse(VolleyError error) {
                 Toast.makeText(AccountBalance.this, "Fail to get data..", Toast.LENGTH_SHORT).show();
            }

        });

        queue.add(jsonObjectRequest);

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calender class's instance and get current date , month and year from calender
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day

               // getmonthdetail();
                // date picker dialog
                datePickerDialog = new DatePickerDialog(AccountBalance.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                date.setText(dayOfMonth + "/"
                                        + (monthOfYear + 1) + "/" + year);
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });
    }

    private void accountsummary() {

        btndetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                JsonObjectRequest jsonObjectRequest1 = new JsonObjectRequest(Request.Method.GET, url1, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String bonusPoint = response.getString("bonus_point");
                            String Point = response.getString("points");
                            String orderPoint = response.getString("Order_point");
                            String closingBalance = response.getString("closing_bal");

                            bonuspointac.setText(bonusPoint);
                            pointac.setText(Point);
                            orderpointac.setText(orderPoint);
                            closingbalanceac.setText(closingBalance);

                        } catch (JSONException e) {

                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(AccountBalance.this, "Fail to get data..", Toast.LENGTH_SHORT).show();
                    }

                });
               // queue.add(jsonObjectRequest1);
            }
        });

    }

}
