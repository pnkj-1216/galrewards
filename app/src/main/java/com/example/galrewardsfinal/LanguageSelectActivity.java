package com.example.galrewardsfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class LanguageSelectActivity extends AppCompatActivity {

    TextView login,dialog_language;
    int lang_selected;
    RelativeLayout show_lan_dialog;

    Context context;
    Resources resources;
    Button btnlng;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language_select);

        dialog_language = (TextView)findViewById(R.id.dialog_language);
        login =(TextView)findViewById(R.id.helloworld);
        show_lan_dialog = (RelativeLayout)findViewById(R.id.showlangdialog);
        btnlng = (Button) findViewById(R.id.btnlangselect);

        btnlng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LanguageSelectActivity.this,AppMainScreenActivity.class);
                startActivity(intent);
            }
        });
        if(LocaleHelper.getLanguage(LanguageSelectActivity.this).equalsIgnoreCase("en"))
        {
            context = LocaleHelper.setLocale(LanguageSelectActivity.this,"en");
            resources =context.getResources();
            dialog_language.setText("ENGLISH");
            login.setText(resources.getString(R.string.login));
            setTitle(resources.getString(R.string.app_name));
            lang_selected = 0;
        }else if(LocaleHelper.getLanguage(LanguageSelectActivity.this).equalsIgnoreCase("fr")){
            context = LocaleHelper.setLocale(LanguageSelectActivity.this,"fr");
            resources =context.getResources();
            dialog_language.setText("France");
            login.setText(resources.getString(R.string.login));
            setTitle(resources.getString(R.string.app_name));
            lang_selected =1;
        }

        show_lan_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String[] Language = {"ENGLISH","FRENCH"};
                final int checkItem;
                Log.d("Clicked","Clicked");
                final AlertDialog.Builder builder = new AlertDialog.Builder(LanguageSelectActivity.this);
                builder.setTitle("SELECT A LANGUAGE")
                        .setSingleChoiceItems(Language, lang_selected, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialog_language.setText(Language[i]);
                                if (Language[i].equals("ENGLISH")) {
                                    context = LocaleHelper.setLocale(LanguageSelectActivity.this, "en");
                                    resources = context.getResources();
                                    lang_selected = 0;
                                    login.setText(resources.getString(R.string.login));
                                    setTitle(resources.getString(R.string.app_name));
                                }
                                if (Language[i].equals("FRENCH")) {
                                    context = LocaleHelper.setLocale(LanguageSelectActivity.this, "fr");
                                    resources = context.getResources();
                                    lang_selected = 1;
                                    login.setText(resources.getString(R.string.login));
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


    }
}