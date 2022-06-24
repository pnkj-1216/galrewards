package com.example.galrewardsfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

public class SearchBarActivity1 extends AppCompatActivity {
    SearchView searchView;
    ListView listView;
    ArrayList<String> list;
    ArrayAdapter<String > adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_bar1);

        searchView = (SearchView) findViewById(R.id.searchView);
        listView = (ListView) findViewById(R.id.lv1);

        list = new ArrayList<>();
        list.add("testing");
        list.add("demo");
        list.add("EvoFox Game Box");
        list.add("Levis - Digital Voucher");
        list.add("OnePlus Nord 2 5G");
        list.add("XX3 Cologne Spray for Men");
        list.add("boAt Airdopes");
        list.add("(Renewed) Dell Optiplex 380 17 inch");
        list.add("MSI Bravo 15 Ryzen");
        list.add("HP 15 Thin And Light 11th Gen Intel Core i5");
        list.add("Synqe USB Type Headset");
        list.add("iBall EarWear Sporty Wireless Bluetooth in Ear Headset with");

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,list);
        listView.setAdapter(adapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                if(list.contains(query)){
                    adapter.getFilter().filter(query);
                }else{
                    Toast.makeText(SearchBarActivity1.this, "No Match found",Toast.LENGTH_LONG).show();
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //    adapter.getFilter().filter(newText);
                return false;
            }
        });
    }
}
