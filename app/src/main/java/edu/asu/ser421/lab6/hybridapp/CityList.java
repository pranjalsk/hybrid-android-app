package edu.asu.ser421.lab6.hybridapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import android.util.Log;
import java.util.ArrayList;

public class CityList extends Activity implements View.OnClickListener{
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
    ArrayList<String> citiesChecked =  new ArrayList<String>();

    private JsHandler _jsHandler;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_list);

        // Get the object reference of listview from the layout
        ListView listView = ( ListView ) findViewById(R.id.listview);

        // Instantiating an array adapter for listview
        ArrayAdapter<String> adapter  = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_multiple_choice, cities);
        listView.setAdapter(adapter);

        //Defining an item click listener
        OnItemClickListener itemClickListener = new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long id) {
                // AdapterView is the parent class of ListView
                try{
                    ListView lv = (ListView) arg0;
                    if(lv.isItemChecked(position)){
                        citiesChecked.add(cities[position]);
                        //Toast.makeText(getBaseContext(), "You checked " + cities[position], Toast.LENGTH_SHORT).show();
                    }else{

                        citiesChecked.remove(position);
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


        //------------------------------------------------------
        // GetWeather Button
        Button btn = (Button)findViewById(R.id.getWeatherButton);
        btn.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.getWeatherButton:
                _jsHandler.javaFnCall(citiesChecked.get(0),citiesChecked.get(1),citiesChecked.get(2),citiesChecked.get(3),citiesChecked.get(4));
                //Intent to move next page
                Intent intent=new  Intent(CityList.this,MainActivity.class);
                startActivity(intent);
                break;

            default:
                break;
        }
    }
}