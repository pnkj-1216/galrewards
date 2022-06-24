
package com.example.galrewardsfinal;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ForgotPassword extends AppCompatActivity {



    private EditText nameEdtforemail,nameEdtforpass, jobEdtforcpass;
    private Button postDataBtn;
    private TextView responseTV;
    private ProgressBar loadingPB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        nameEdtforemail = findViewById(R.id.userchngemail);
        nameEdtforpass = findViewById(R.id.idEdtNameforpass);
        jobEdtforcpass = findViewById(R.id.idEdtJobforcpass);
        postDataBtn = findViewById(R.id.idBtnPostforpass);
        responseTV = findViewById(R.id.idTVResponseforpass);
        loadingPB = findViewById(R.id.idLoadingPB);

        // adding on click listener to our button.
        postDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // validating if the text field is empty or not.
                if (nameEdtforemail.getText().toString().isEmpty() && nameEdtforpass.getText().toString().isEmpty() && jobEdtforcpass.getText().toString().isEmpty()) {
                    Toast.makeText(ForgotPassword.this, "Please enter the values", Toast.LENGTH_SHORT).show();
                    return;
                }
                // calling a method to post the data and passing our name and job.
                postData(nameEdtforemail.getText().toString(),nameEdtforpass.getText().toString(), jobEdtforcpass.getText().toString());
            }
        });
    }

    private void postData(String email,String password,String confirmpassword){
//        loadingPB.setVisibility(View.VISIBLE);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://mygalrewards.com/galrewards/api/password/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ChangePassword changePassword = retrofit.create(ChangePassword.class);

        ChngPassword chngPassword = new ChngPassword(email,password,confirmpassword);

        Call<ChngPassword> call = changePassword.createPost(chngPassword);

        call.enqueue(new Callback<ChngPassword>() {
            @Override
            public void onResponse(Call<ChngPassword> call, Response<ChngPassword> response) {
                //Toast.makeText(ForgotPassword.this,"Password Change Successfully", Toast.LENGTH_SHORT).show();

//                loadingPB.setVisibility(View.GONE);

                nameEdtforemail.setText("");
                nameEdtforpass.setText("");
                jobEdtforcpass.setText("");

                ChngPassword responseFROMAPI = response.body();

                String responseString = "Response Code: " + response.code() + "\nemail : " + responseFROMAPI.getEmail() + "\n" + "password: " + responseFROMAPI.getNewpassword() + "\n" + "confirm_password: " + responseFROMAPI.getConfpassword();

                responseTV.setText(responseString);
            }

            @Override
            public void onFailure(Call<ChngPassword> call, Throwable t) {

                responseTV.setText("Not Match " + t.getMessage());

            }
        });
    }}

 /* private void postDataUsingVolley(String email, String password, String confirmpassword) {
        // url to post our data
        String url = "http://mygalrewards.com/galrewards/api/password/";
        loadingPB.setVisibility(View.VISIBLE);

        // creating a new variable for our request queue
        RequestQueue queue = Volley.newRequestQueue(ForgotPassword.this);

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
                nameEdtforpass.setText("");
                jobEdtforcpass.setText("");

                // on below line we are displaying a success toast message.
                Toast.makeText(ForgotPassword.this, "Data added to API", Toast.LENGTH_SHORT).show();
                try {
                    // on below line we are passing our response
                    // to json object to extract data from it.
                    JSONObject respObj = new JSONObject(response);

                    // below are the strings which we
                    // extract from our json object.
                    String email = respObj.getString("email");
                    String password = respObj.getString("password");
                    String confirmpassword = respObj.getString("confirm_password");

                    // on below line we are setting this string s to our text view.
                    responseTV.setText("email: " + email+"\n"+ "Password : " + password + "\n" + "ConfirmPassword : " + confirmpassword);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // method to handle errors.
                Toast.makeText(ForgotPassword.this, "Fail to get response = " + error, Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {

                Map<String, String> params = new HashMap<String, String>();


                params.put("email",email);
                params.put("password", password);
                params.put("confirm_password", confirmpassword);


                return params;
            }
        };

        queue.add(request);


    }}

*/