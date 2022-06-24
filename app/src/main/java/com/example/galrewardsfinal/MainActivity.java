package com.example.galrewardsfinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
        //LocalUrl
  //  private String URLline = "http://mygalrewards.com/galrewards/api/login";

    private String URLline = "http://mygalrewards.com/galrewards/api/login";
  //  private String;
    private EditText etUname, etPass;
    private Button btn;
    public static String firstName, hobby;
    TextView forgotpassword;
    private CheckBox saveLoginCheckBox;
    private SharedPreferences loginPreferences;
    private SharedPreferences.Editor loginPrefsEditor;
    private Boolean saveLogin;
    private String username,password;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        saveLoginCheckBox = (CheckBox)findViewById(R.id.saveLoginCheckBox);
        loginPreferences = getSharedPreferences("loginPrefs", MODE_PRIVATE);
        loginPrefsEditor = loginPreferences.edit();

        saveLogin = loginPreferences.getBoolean("saveLogin", false);
        if (saveLogin == true) {
            etUname.setText(loginPreferences.getString("username", ""));
            etPass.setText(loginPreferences.getString("password", ""));
            saveLoginCheckBox.setChecked(true);
        }
    }

    public void onClick(View view) {
        if (view == btn) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(etUname.getWindowToken(), 0);

          username = etUname.getText().toString();
            password = etPass.getText().toString();

            if (saveLoginCheckBox.isChecked()) {
                loginPrefsEditor.putBoolean("saveLogin", true);
                loginPrefsEditor.putString("username", "");
                loginPrefsEditor.putString("password", "");
                loginPrefsEditor.commit();
            } else {
                loginPrefsEditor.clear();
                loginPrefsEditor.commit();
            }

            doSomethingElse();
        }
    }

    public void doSomethingElse() {
        startActivity(new Intent(MainActivity.this, AppMainScreenActivity.class));
        MainActivity.this.finish();



        etUname =(EditText) findViewById(R.id.etusername);
        etPass = (EditText)findViewById(R.id.etpassword);
        btn = (Button) findViewById(R.id.btn);

        forgotpassword = (TextView)findViewById(R.id.idforgotpassword);

        forgotpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MainActivity.this,ForgotPassword.class);
                startActivity(in);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });
        }



    private void loginUser(){

        final String username = etUname.getText().toString().trim();
        final String password = etPass.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URLline,
                new com.android.volley.Response.Listener<String>(){
                    @Override
                    public void onResponse(String response) {
                        etUname.setText("");
                        etPass.setText("");
                        Toast.makeText(MainActivity.this,response,Toast.LENGTH_LONG).show();
                        parseData(response);
                        Intent intent = new Intent(MainActivity.this,AppMainScreenActivity.class);
                        startActivity(intent);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this,error.toString(),Toast.LENGTH_LONG).show();
                    }
                }){


                @Override
            protected Map<String,String> getParams() {
                Map<String,String> params = new HashMap<String, String>();


                params.put("email",username);
                params.put("password",password);
                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<>();

                headers.put("Content-Type", "application/x-www-form-urlencoded");
                return headers;
            }

        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    public void parseData(String response) {


        try {
            JSONObject jsonObject = new JSONObject(response);
            if (jsonObject.getString("username").equals("true")) {
                JSONArray dataArray = jsonObject.getJSONArray("data");
                for (int i = 0; i < dataArray.length(); i++) {
                    JSONObject dataobj = dataArray.getJSONObject(i);
                    firstName = dataobj.getString("email");
                    hobby = dataobj.getString("password");

                }
                //Intent intent = new Intent(MainActivity.this,AppMainScreenActivity.class);
               // startActivity(intent);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}


//Old Code OF Login
/*    EditText edtUsername;
    EditText edtPassword;
    Button btnlogin;
    TextView fname,lname,email,forgotpassword;
    private TextView responseTV;
    private  ProgressBar loadingPB;
    UserService userService;*/

    /*Language Code

    TextView login,dialog_language;
    int lang_selected;
    RelativeLayout show_lan_dialog;

    Context context;
    Resources resources;

*/





//Old COde Login

       /* edtUsername = (EditText) findViewById(R.id.edt_email);
        edtPassword = (EditText) findViewById(R.id.edt_password);
        btnlogin = (Button) findViewById(R.id.btn_email_sign_in);
        responseTV = findViewById(R.id.idTVResponse);
        loadingPB = findViewById(R.id.idLoadingPB);*/
/*
        //language Code
        dialog_language = (TextView)findViewById(R.id.dialog_language);
        login =(TextView)findViewById(R.id.helloworld);
        show_lan_dialog = (RelativeLayout)findViewById(R.id.showlangdialog);
        if(LocaleHelper.getLanguage(MainActivity.this).equalsIgnoreCase("en"))
        {
            context = LocaleHelper.setLocale(MainActivity.this,"en");
            resources =context.getResources();
            dialog_language.setText("ENGLISH");
            //login.setText(resources.getString(R.string.login));
            setTitle(resources.getString(R.string.app_name));
            lang_selected = 0;
        }else if(LocaleHelper.getLanguage(MainActivity.this).equalsIgnoreCase("hi")){
            context = LocaleHelper.setLocale(MainActivity.this,"hi");
            resources =context.getResources();
            dialog_language.setText("France");
          //  login.setText(resources.getString(R.string.login));
            setTitle(resources.getString(R.string.app_name));
            lang_selected =1;
        }

        show_lan_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String[] Language = {"ENGLISH","FRENCH"};
                final int checkItem;
                Log.d("Clicked","Clicked");
                final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("SELECT A LANGUAGE")
                        .setSingleChoiceItems(Language, lang_selected, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialog_language.setText(Language[i]);
                                if (Language[i].equals("ENGLISH")) {
                                    context = LocaleHelper.setLocale(MainActivity.this, "en");
                                    resources = context.getResources();
                                    lang_selected = 0;
                                    //login.setText(resources.getString(R.string.login));
                                    setTitle(resources.getString(R.string.app_name));
                                }
                                if (Language[i].equals("FRENCH")) {
                                    context = LocaleHelper.setLocale(MainActivity.this, "fr");
                                    resources = context.getResources();
                                    lang_selected = 1;
                                    //login.setText(resources.getString(R.string.login));
                                    setTitle(resources.getString(R.string.app_name));
                                }

                            }}).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                builder.create().show();
            }
        });
        //End of Language Code

        */

        //userService = ApiUtils.getUserService();


//Old Code Login


            /*btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            //    Intent ii = new Intent(MainActivity.this, AppMainScreenActivity.class);
              //  startActivity(ii);
               //Toast.makeText(MainActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();

                if (edtUsername.getText().toString().isEmpty() && edtPassword.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter both the values", Toast.LENGTH_SHORT).show();
                    return;
                }
                // calling a method to post the data and passing our name and job.
                postDataUsingVolley(edtUsername.getText().toString(), edtPassword.getText().toString());
            }
        });
        }

            private void postDataUsingVolley(String email, String password) {

        // url to post our data
        //String url = "http://192.168.177.120/galrewards/api/login/";
             String url = "http://mygalrewards.com/galrewards/api/login";
        //String url1 = "http://192.168.177.120/gelrewards/api/user/profile/";

            loadingPB.setVisibility(View.VISIBLE);

        // creating a new variable for our /request queue
            RequestQueue queue = Volley.newRequestQueue(MainActivity.this);

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
                edtUsername.setText("");
                edtPassword.setText("");
                // fname.setText("");
                // lname.setText("");

                // on below line we are displaying a success toast message.
               // (MainLine before this)
                    Intent intent = new Intent(MainActivity.this, AppMainScreenActivity.class);
                  //Intent intent = new Intent(MainActivity.this, NewDynamicHomePage.class);

                    intent.putExtra("email", email);

              //  intent.putExtra("first_name", (Parcelable) fname);
                //intent.putExtra("last_name", (Parcelable) lname);
                //intent.putExtra("country_name", email);
                //Main Toast msg
               // Toast.makeText(MainActivity.this, "Fail to get response = ", Toast.LENGTH_SHORT).show();

                //Testing Toast
                Toast.makeText(MainActivity.this, "Successfull Login", Toast.LENGTH_SHORT).show();


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

                    //
                    // JsonArray jsonArray = JSONObject.getJsonArray("id");

                    // below are the strings which we
                    // extract from our json object.
                  //  String email = respObj.getString("email");
                 //   String password = respObj.getString("password");
                   // String firstname = respObj.getString("first_name");
                   // String lastname = respObj.getString("last_name");
//
                    // on below line we are setting this string s to our text view.
                  //  responseTV.setText("Email : " + email + "\n" + "Password : " + password + "\n" + "first_name : " + firstname + "\n"+
                            //"last_name:" + lastname + "\n");

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Toast.makeText(MainActivity.this, "Fail to get response = " + error, Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                // below line we are creating a map for
                // storing our values in key and value pair.
                Map<String, String> params = new HashMap<String, String>();

                // on below line we are passing our key
                // and value pair to our parameters.
                params.put("email", email);
                params.put("password", password);
                //params.put("first_name", email);
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
}
*/
