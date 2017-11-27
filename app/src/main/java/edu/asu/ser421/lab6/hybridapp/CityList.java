package edu.asu.ser421.lab6.hybridapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

public class CityList extends Activity{
    private static final String tag="mytag";
    String[] cities = new String[] {
            "Denver",
            "Boston",
            "Seattle",
            "Chicago",
            "Austin",
            "Houston",
            "Nashville",
            "Pittsburgh",
            "Orlando",
            "Tampa"
    };
    ArrayList<String> citiesChecked;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_list);

        citiesChecked =  new ArrayList<String>();
        // Get the object reference of listview from the layout
        ListView listView = ( ListView ) findViewById(R.id.listview);

        // Instantiating an array adapter for listview
        ArrayAdapter<String> adapter  = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_multiple_choice, cities);
        listView.setAdapter(adapter);
        final Button btn = (Button)findViewById(R.id.getWeatherButton);
        btn.setEnabled(false);
        //Defining an item click listener
        OnItemClickListener itemClickListener = new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long id) {
                // AdapterView is the parent class of ListView
                try{
                    ListView lv = (ListView) arg0;
                    if(lv.isItemChecked(position)){
                        citiesChecked.add(cities[position]);
                        if(citiesChecked.size()==5)
                        {
                            btn.setEnabled(true);
                        }else if(citiesChecked.size()>5){
                            btn.setEnabled(false);
                            Toast.makeText(getBaseContext(), "You should select exactly 5 cities", Toast.LENGTH_LONG).show();
                        }else{
                            btn.setEnabled(false);
                        }
                        //Toast.makeText(getBaseContext(), "You checked " + cities[position], Toast.LENGTH_SHORT).show();
                    }else{
                        citiesChecked.remove(position);
                        if(citiesChecked.size()==5)
                        {
                            btn.setEnabled(true);
                        }else{
                            btn.setEnabled(false);
                            Toast.makeText(getBaseContext(), "You should select exactly 5 cities", Toast.LENGTH_LONG).show();
                        }
                        //Toast.makeText(getBaseContext(), "You unchecked " + cities[position], Toast.LENGTH_SHORT).show();
                    }
                    Log.i(tag,citiesChecked.toString());
                }
                catch( Exception e_){
                    Log.i(tag, e_.getMessage());
                }

            }
        };

        // Setting the ItemClickEvent listener for the listview
        listView.setOnItemClickListener(itemClickListener);

        // GetWeather Button

        btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                if(citiesChecked.size()==5){
                    Intent intent = new Intent(CityList.this, WebviewActivity.class);
                    intent.putExtra("citiesSelected",citiesChecked);
                    startActivity(intent);
                }else{
                    Toast.makeText(getBaseContext(), "You should select exactly 5 cities", Toast.LENGTH_LONG).show();
                }

            }
        });

    }

}