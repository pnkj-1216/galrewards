package com.example.galrewardsfinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RaiseANewTicket extends AppCompatActivity{


    //CheckBox android, java, python, php, unity3D;
   // Button sbmt;
    // EditText comment;
    CheckBox check1,check2,check3,check4;
    private EditText nameEdt, jobEdt,userid;
    private Button postDataBtn;
    private TextView responseTV;
    private ProgressBar loadingPB;
    Spinner spinner;
    String[]name={"Desired Reward Not Available In Item","Discrepancy In Points Earned",
            "Item Not Delivered/Wrong Item Delivered","Other"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raise_anew_ticket);

      //  userid = findViewById(R.id.idEdtName);
        nameEdt = findViewById(R.id.idEdtName);
        jobEdt = findViewById(R.id.idEdtJob);
        postDataBtn = findViewById(R.id.idBtnPost);
        responseTV = findViewById(R.id.idTVResponse);
        loadingPB = findViewById(R.id.idLoadingPB);
        spinner = findViewById(R.id.spinner);

        //BaseUrl = "http://mygalrewards.com/galrewards/api/ticket/";

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,name);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);


        // adding on click listener to our button.
        postDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // validating if the text field is empty or not.
                if (nameEdt.getText().toString().isEmpty() && jobEdt.getText().toString().isEmpty()){
                        //&&  check1.getText().toString().isEmpty() && check2.getText().toString().isEmpty() && check3.getText().toString().isEmpty()
                       // && check4.getText().toString().isEmpty()) {
                    Toast.makeText(RaiseANewTicket.this, "Please enter your email and comment", Toast.LENGTH_SHORT).show();
                    return;
                }
                // calling a method to post the data and passing our name and job.
                postDataUsingVolley(nameEdt.getText().toString(), jobEdt.getText().toString());
//                          check1.getText().toString(),check2.getText().toString(),check3.getText().toString(),check4.getText().toString());
            }
        });


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

    private void postDataUsingVolley(String name, String job) {
        // url to post our data
        String url = "http:mygalrewards.com/galrewards/api/ticket/?user_id=77&need_assistance=other&comment=test";
        loadingPB.setVisibility(View.VISIBLE);

        // creating a new variable for our request queue
        RequestQueue queue = Volley.newRequestQueue(RaiseANewTicket.this);

        // on below line we are calling a string
        // request method to post the data to our API
        // in this we are calling a post method.
        StringRequest request = new StringRequest(Request.Method.POST, url, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                // inside on response method we are
                // hiding our progress bar
                // and setting data to edit text as empty
                loadingPB.setVisibility(View.GONE);

              //  userid.setText("");
                nameEdt.setText("");
                jobEdt.setText("");
               // check1.setText("");
                //check2.setText("");
                //check3.setText("");
                //check4.setText("");
                //check1.setText("");

                // on below line we are displaying a success toast message.
                Toast.makeText(RaiseANewTicket.this, "Successfully Raise A Ticket", Toast.LENGTH_SHORT).show();
                try {
                    // on below line we are passing our response
                    // to json object to extract data from it.
                    JSONObject respObj = new JSONObject(response);

                    // below are the strings which we
                    // extract from our json object.
                   // Integer userid = respObj.getInt("user_id");
                    String name = respObj.getString("need_assistance");
                    String job = respObj.getString("comment");

                    // on below line we are setting this string s to our text view.
                    responseTV.setText("need_assistance : " + name + "\n" + "comment : " + job);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new com.android.volley.Response.ErrorListener() {


            @Override
            public void onErrorResponse(VolleyError error) {
                // method to handle errors.
                Toast.makeText(RaiseANewTicket.this, "Fail to get response = " + error, Toast.LENGTH_SHORT).show();
            }
        })

        {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<>();

        /*change content-type to "application/x-www-form-urlencoded" from
         "application/json"
         */

                headers.put("Content-Type", "application/x-www-form-urlencoded");
                return headers;
            }


                //Old CODE

            @Override
            protected Map<String, String> getParams() {
                // below line we are creating a map for
                // storing our values in key and value pair.
               Map<String, String> params = new HashMap<String, String>();

                // on below line we are passing our key
                // and value pair to our parameters.
                //params.put("user_id", userid);
                params.put("need_assistance", name);
                params.put("comment", job);

                // at last we are
                // returning our params.
                return params;
            }
        };
        // below line is to make
        // a json object request.
        queue.add(request);
    }}

       /* nameEdt = findViewById(R.id.idEdtName);
        jobEdt = findViewById(R.id.idEdtJob);
        postDataBtn = findViewById(R.id.idBtnPost);
        responseTV = findViewById(R.id.idTVResponse);
        loadingPB = findViewById(R.id.idLoadingPB);

        // adding on click listener to our button.
        postDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // validating if the text field is empty or not.
                if (nameEdt.getText().toString().isEmpty() && jobEdt.getText().toString().isEmpty()) {
                    Toast.makeText(RaiseANewTicket.this, "Please enter both the values", Toast.LENGTH_SHORT).show();
                    return;
                }
                // calling a method to post the data and passing our name and job.
                postData(nameEdt.getText().toString(), jobEdt.getText().toString());
            }
        });
    }

    private void postData(String need_assistance, String comment) {

        // below line is for displaying our progress bar.
        loadingPB.setVisibility(View.VISIBLE);

        // on below line we are creating a retrofit
        // builder and passing our base url
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http:mygalrewards.com/test/api.php")
                // as we are sending data in json format so
                // we have to add Gson converter factory
                .addConverterFactory(GsonConverterFactory.create())
                // at last we are building our retrofit builder.
                .build();
        // below line is to create an instance for our retrofit api class.
        UserService retrofitAPI = retrofit.create(UserService.class);

        // passing data from our text fields to our modal class.
        DataModel modal = new DataModel(need_assistance,comment);

        // calling a method to create a post and passing our modal class.
        Call<DataModel> call = retrofitAPI.createPost(modal);

        // on below line we are executing our method.
        call.enqueue(new Callback<DataModel>() {
         //   @Override
            public void onResponse(Call<DataModel> call, Response<DataModel> response) {
                // this method is called when we get response from our api.
                Toast.makeText(RaiseANewTicket.this, "Data added to API", Toast.LENGTH_SHORT).show();

                // below line is for hiding our progress bar.
                loadingPB.setVisibility(View.GONE);

                // on below line we are setting empty text
                // to our both edit text.
                jobEdt.setText("");
                nameEdt.setText("");

                // we are getting response from our body
                // and passing it to our modal class.
                DataModel responseFromAPI = response.result;

                // on below line we are getting our data from modal class and adding it to our string.
                String responseString = "need_assistance : " + responseFromAPI.getNeed_assistance() + "\n" + "comment : " + responseFromAPI.getComment();

                // below line we are setting our
                // string to our text view.
                responseTV.setText(responseString);
            }

           @Override
            public void onResponse(Call<DataModel> call, retrofit2.Response<DataModel> response) {

            }

            @Override
            public void onFailure(Call<DataModel> call, Throwable t) {
                // setting text to our text view when
                // we get error response from API.
                responseTV.setText("Error found is : " + t.getMessage());
            }
        });
    }}
/*
        android = (CheckBox) findViewById(R.id.androidCheckBox);
        android.setOnClickListener(this);
        java = (CheckBox) findViewById(R.id.javaCheckBox);
        java.setOnClickListener( this);
        python = (CheckBox) findViewById(R.id.pythonCheckBox);
        python.setOnClickListener(this);
        php = (CheckBox) findViewById(R.id.phpCheckBox);

        comment = (EditText)findViewById(R.id.sbmtcomment);
        php.setOnClickListener(this);

        sbmt = (Button) findViewById(R.id.btnraisesbmt);

        sbmt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             //  String url =  "http://mygalrewards.com/galrewards/api/ticket";
               // Toast.makeText(RaiseANewTicket.this, "Data Send To Server ", Toast.LENGTH_SHORT).show();
                Intent ii = new Intent(RaiseANewTicket.this, AppMainScreenActivity.class);
                startActivity(ii);



               // if(android.setOnClickListener(getText().);)


            }
         //   void postDataUsingVolley(CheckBox.setText().toString(), edtPassword.getText().toString());

        });

        //private void postDataUsingVolley(String) {

            // url to post our data
            //String url = "http://192.168.177.120/galrewards/api/login/";
         //   String url = "http://mygalrewards.com/galrewards/api/login";
        /*    String url  = "http://103.159.183.120/galrewards/api/ticket";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(RaiseANewTicket.this,response,Toast.LENGTH_LONG).show();

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(RaiseANewTicket.this,error.toString(),Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put(comment,"");
             //   params.put(comment,username);
               // params.put(KEY_PASSWORD,password);
               // params.put(KEY_EMAIL, email);
                return params;
            }

        };}

    @Override
    public void onClick(View view) {

    }
}

     //   getRequestOtpPage().addToRequestQueue(stringRequest);}}



            String url1 = "http://mygalrewards.com/galrewards/api/ticket";

       //     loadingPB.setVisibility(View.VISIBLE);

            // creating a new variable for our /request queue
            RequestQueue queue = Volley.newRequestQueue(RaiseANewTicket.this);

            // on below line we are calling a string
            // request method to post the data to our API
            // in this we are calling a post method.

            StringRequest request = new StringRequest(Request.Method.POST, url1, new com.android.volley.Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    // inside on response method we are
                    // hiding our progress bar
                    // and setting data to edit text as empty
                   // loadingPB.setVisibility(View.GONE);
                  //  edtUsername.setText("");
                   // edtPassword.setText("");
                    // fname.setText("");
                    // lname.setText("");
                    comment.setText("");

                    // on below line we are displaying a success toast message.
                    Intent intent = new Intent(RaiseANewTicket.this, AppMainScreenActivity.class);
                    //  Intent intent = new Intent(MainActivity.this, AccountBalance.class);

                    intent.putExtra("comment", "");

                    //  intent.putExtra("first_name", (Parcelable) fname);
                    //intent.putExtra("last_name", (Parcelable) lname);
                    //intent.putExtra("country_name", email);

                    Toast.makeText(RaiseANewTicket.this, "Fail to get response = ", Toast.LENGTH_SHORT).show();

                    //intent.putExtra("date_of_birth", email);
                    // intent.putExtra("sign_on", email);
                    // intent.putExtra("pcc", email);
                    // intent.putExtra("contact", email);
                    // intent.putExtra("points", email);
                    startActivity(intent);
                    try {
                        // on below line we are passing our response
                        // to json object to extract data from it.
                        JSONObject respObj = new JSONObject(response);

                        // JsonArray jsonArray = JSONObject.getJsonArray("id");

                        // below are the strings which we
                        // extract from our json object.
                       // String email = respObj.getString("email");
                       // String password = respObj.getString("password");
                      //  String firstname = respObj.getString("first_name");
                      //  String lastname = respObj.getString("last_name");

                        // on below line we are setting this string s to our text view.
                   //     responseTV.setText("Email : " + email + "\n" + "Password : " + password + "\n" + "first_name : " + firstname + "\n"+
                               // "last_name:" + lastname + "\n");

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }, new com.android.volley.Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    error.printStackTrace();
                    Toast.makeText(RaiseANewTicket.this, "Fail to get response = " + error, Toast.LENGTH_SHORT).show();
                }
            }) {
                @Override
                protected Map<String, String> getParams() {
                    // below line we are creating a map for
                    // storing our values in key and value pair.
                    Map<String, String> params = new HashMap<String, String>();

                    // on below line we are passing our key
                    // and value pair to our parameters.
                    params.put("comment", "");
                  //  params.put("need_assistance", "");
                    //params.put("ticket_date", "");
                    //params.put("last_name", email);
                    // //params.put("country_name", email);
                    // params.put("date_of_birth", email);
                    // params.put("sign_on", email);
                    // params.put("pcc", email);
                    // params.put("contact", email);
                    // params.put("points", email);

                    // at last we are
                    // returning our params.
                    return params;
                }
            };
            // below line is to make
            // a json object request.
            queue.add(request);
        }


            // unity3D = (CheckBox) findViewById(R.id.unityCheckBox);
       // unity3D.setOnClickListener(this);


    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.androidCheckBox:
                if (android.isChecked())
                    Toast.makeText(getApplicationContext(), "Need Assistance From", Toast.LENGTH_LONG).show();
                break;
            case R.id.javaCheckBox:
                if (java.isChecked())
                    Toast.makeText(getApplicationContext(), "Desired Reward Not Available In Item", Toast.LENGTH_LONG).show();
                break;
            case R.id.phpCheckBox:
                if (php.isChecked())
                    Toast.makeText(getApplicationContext(), "Discrepancy In Points Earned", Toast.LENGTH_LONG).show();
                break;
            case R.id.pythonCheckBox:
                if (python.isChecked())
                    Toast.makeText(getApplicationContext(), "Item Not Declared/Wrong Item Delivered", Toast.LENGTH_LONG).show();
                    Toast.makeText(getApplicationContext(), "Item Not Declared/Wrong Item Delivered", Toast.LENGTH_LONG).show();
                break;
          //  case R.id.unityCheckBox:
                //if (unity3D.isChecked())
                 //   Toast.makeText(getApplicationContext(), "Unity 3D", Toast.LENGTH_LONG).show();
               // break;
        }
    }
}*/