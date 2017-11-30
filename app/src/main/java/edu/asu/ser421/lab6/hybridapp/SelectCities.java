package edu.asu.ser421.lab6.hybridapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.ArrayList;

public class SelectCities extends AppCompatActivity {

    private CheckBox chkDenver, chkChicago, chkBoston,chkSeattle,chkAustin,chkHouston, chkPortland,
            chkPittsburgh,chkOrlando,chkTampa;
    private Button showWeather,btnChange,btnDenver,btnChicago,btnBoston,btnSeattle,btnAustin,btnHouston, btnPortland,
    btnPittsburgh,btnOrlando,btnTampa;
    ArrayList<String> citiesChecked, currentcities;
    private String tag = "mytag";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_cities);

        addListenerOnButton();
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        WebviewActivity webAct = new WebviewActivity();
        System.out.println("Inside kill");
        webAct.browser.evaluateJavascript("clearLocalStorage()",null);

        //browser.evaluateJavascript("clearLocalStorage()",null);
        //Do whatever you want to do when the application is destroyed.
    }

    public void addListenerOnButton() {
        currentcities = new ArrayList<String>();
        citiesChecked =  new ArrayList<String>();

        chkDenver = (CheckBox) findViewById(R.id.chkDenver);
        chkChicago = (CheckBox) findViewById(R.id.chkChicago);
        chkBoston = (CheckBox) findViewById(R.id.chkBoston);
        chkSeattle = (CheckBox) findViewById(R.id.chkSeattle);
        chkAustin = (CheckBox) findViewById(R.id.chkAustin);
        chkHouston = (CheckBox) findViewById(R.id.chkHouston);
        chkPortland = (CheckBox) findViewById(R.id.chkPortland);
        chkPittsburgh = (CheckBox) findViewById(R.id.chkPittsburgh);
        chkOrlando = (CheckBox) findViewById(R.id.chkOrlando);
        chkTampa = (CheckBox) findViewById(R.id.chkTampa);
        citiesChecked.add("Denver");
        citiesChecked.add("Chicago");
        citiesChecked.add("Boston");
        citiesChecked.add("Seattle");
        citiesChecked.add("Austin");
        currentcities = citiesChecked;



        showWeather = (Button) findViewById(R.id.showWeather);
        btnChange = (Button) findViewById(R.id.change);

        btnDenver = (Button) findViewById(R.id.btnDenver);
        btnChicago = (Button) findViewById(R.id.btnChicago);
        btnBoston = (Button) findViewById(R.id.btnBoston);
        btnSeattle = (Button) findViewById(R.id.btnSeattle);
        btnAustin = (Button) findViewById(R.id.btnAustin);
        btnHouston = (Button) findViewById(R.id.btnHouston);
        btnPortland = (Button) findViewById(R.id.btnPortland);
        btnPittsburgh = (Button) findViewById(R.id.btnPittsburgh);
        btnOrlando = (Button) findViewById(R.id.btnOrlando);
        btnTampa = (Button) findViewById(R.id.btnTampa);


        btnChange.setOnClickListener(new View.OnClickListener() {

            //Run when button is clicked
            @Override
            public void onClick(View v) {

                citiesChecked =  new ArrayList<String>();
                if(chkDenver.isChecked()) citiesChecked.add("Denver");
                if(chkChicago.isChecked()) citiesChecked.add("Chicago");
                if(chkBoston.isChecked()) citiesChecked.add("Boston");
                if(chkSeattle.isChecked()) citiesChecked.add("Seattle");
                if(chkAustin.isChecked()) citiesChecked.add("Austin");
                if(chkHouston.isChecked()) citiesChecked.add("Houston");
                if(chkPortland.isChecked()) citiesChecked.add("Portland");
                if(chkPittsburgh.isChecked()) citiesChecked.add("Pittsburgh");
                if(chkOrlando.isChecked()) citiesChecked.add("Orlando");
                if(chkTampa.isChecked()) citiesChecked.add("Tampa");

                if(citiesChecked.size() == 5){
                    currentcities = citiesChecked;
                    Toast.makeText(SelectCities.this, "You selected "+citiesChecked.toString(), Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getBaseContext(), "You should select exactly 5 cities", Toast.LENGTH_LONG).show();
                }
        }
        });

        showWeather.setOnClickListener(new View.OnClickListener() {

            //Run when button is clicked
            @Override
            public void onClick(View v) {
                if(currentcities.size()==5){
                    Intent intent = new Intent(SelectCities.this, WebviewActivity.class);
                    intent.putExtra("citiesSelected",currentcities);
                    startActivityForResult(intent,1);
                }else{
                    Toast.makeText(getBaseContext(), "You should select exactly 5 cities in show weather:- "+ currentcities.size(), Toast.LENGTH_LONG).show();
                }
            }
        });


        //-------
        btnDenver.setOnClickListener(new View.OnClickListener() {
            //Run when button is clicked
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(SelectCities.this, CityInfoWebview.class);
                    intent.putExtra("cityName","Denver-CO");
                    startActivity(intent);
            }
        });

        btnChicago.setOnClickListener(new View.OnClickListener() {
            //Run when button is clicked
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectCities.this, CityInfoWebview.class);
                intent.putExtra("cityName","Chicago-IL");
                startActivity(intent);
            }
        });

        btnBoston.setOnClickListener(new View.OnClickListener() {
            //Run when button is clicked
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectCities.this, CityInfoWebview.class);
                intent.putExtra("cityName","Boston-MA");
                startActivity(intent);
            }
        });

        btnSeattle.setOnClickListener(new View.OnClickListener() {
            //Run when button is clicked
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectCities.this, CityInfoWebview.class);
                intent.putExtra("cityName","Seattle-WA");
                startActivity(intent);
            }
        });

        btnAustin.setOnClickListener(new View.OnClickListener() {
            //Run when button is clicked
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectCities.this, CityInfoWebview.class);
                intent.putExtra("cityName","Austin-TX");
                startActivity(intent);
            }
        });

        btnHouston.setOnClickListener(new View.OnClickListener() {
            //Run when button is clicked
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectCities.this, CityInfoWebview.class);
                intent.putExtra("cityName","Houston-TX");
                startActivity(intent);
            }
        });

        btnPortland.setOnClickListener(new View.OnClickListener() {
            //Run when button is clicked
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectCities.this, CityInfoWebview.class);
                intent.putExtra("cityName","Portland-OR");
                startActivity(intent);
            }
        });

        btnPittsburgh.setOnClickListener(new View.OnClickListener() {
            //Run when button is clicked
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectCities.this, CityInfoWebview.class);
                intent.putExtra("cityName","Pittsburgh-PA");
                startActivity(intent);
            }
        });

        btnOrlando.setOnClickListener(new View.OnClickListener() {
            //Run when button is clicked
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectCities.this, CityInfoWebview.class);
                intent.putExtra("cityName","Orlando-FL");
                startActivity(intent);
            }
        });

        btnTampa.setOnClickListener(new View.OnClickListener() {
            //Run when button is clicked
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectCities.this, CityInfoWebview.class);
                intent.putExtra("cityName","Tampa-FL");
                startActivity(intent);
            }
        });


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                Log.i(tag, "inside if");
                String result=data.getStringExtra("result");
                cityDisable(result);
                Log.i(tag, result);
            }
            else if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
                Log.i(tag, "inside result cancelled");
            }else{
                Log.i(tag, "nothing came");
            }

        }
    }
    public void cityDisable(String cityname){
        chkDenver.setEnabled(true);
        chkChicago.setEnabled(true);
        chkBoston.setEnabled(true);
        chkSeattle.setEnabled(true);
        chkAustin.setEnabled(true);
        chkHouston.setEnabled(true);
        chkPortland.setEnabled(true);
        chkPittsburgh.setEnabled(true);
        chkOrlando.setEnabled(true);
        chkTampa.setEnabled(true);
        switch (cityname){
            case "Denver":
                chkDenver.setEnabled(false);
                if(!chkDenver.isChecked()){
                    chkDenver.setChecked(true);
                }
                break;
            case "Chicago":
                chkChicago.setEnabled(false);
                if(!chkChicago.isChecked()){
                    chkChicago.setChecked(true);
                }
                break;
            case "Boston":
                chkBoston.setEnabled(false);
                if(!chkBoston.isChecked()){
                    chkBoston.setChecked(true);
                }
                break;
            case "Seattle":
                chkSeattle.setEnabled(false);
                if(!chkSeattle.isChecked()){
                    chkSeattle.setChecked(true);
                }
                break;
            case "Austin":
                chkAustin.setEnabled(false);
                if(!chkAustin.isChecked()){
                    chkAustin.setChecked(true);
                }
                break;
            case "Houston":
                chkHouston.setEnabled(false);
                if(!chkHouston.isChecked()){
                    chkHouston.setChecked(true);
                }
                break;
            case "Portland":
                if(!chkPortland.isChecked()){
                    chkPortland.setChecked(true);
                }
                chkPortland.setEnabled(false);
                break;
            case "Pittsburgh":
                if(!chkPittsburgh.isChecked()){
                    chkPittsburgh.setChecked(true);
                }
                chkPittsburgh.setEnabled(false);
                break;
            case "Orlando":
                if(!chkOrlando.isChecked()){
                    chkOrlando.setChecked(true);
                }
                chkOrlando.setEnabled(false);
                break;
            case "Tampa":
                if(!chkTampa.isChecked()){
                    chkTampa.setChecked(true);
                }
                chkTampa.setEnabled(false);
                break;
        }

    }
}
