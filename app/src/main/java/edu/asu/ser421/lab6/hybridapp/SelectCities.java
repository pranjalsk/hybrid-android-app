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
    private Button showWeather,btnDenver,btnChicago,btnBoston,btnSeattle,btnAustin,btnHouston, btnPortland,
    btnPittsburgh,btnOrlando,btnTampa;
    ArrayList<String> citiesChecked;
    private String tag = "mytag";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_cities);

        addListenerOnButton();
    }

    public void addListenerOnButton() {

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





        showWeather = (Button) findViewById(R.id.showWeather);

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




        showWeather.setOnClickListener(new View.OnClickListener() {

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

                Toast.makeText(SelectCities.this, citiesChecked.toString(),
                        Toast.LENGTH_SHORT).show();

                if(citiesChecked.size()==5){
                    Intent intent = new Intent(SelectCities.this, WebviewActivity.class);
                    intent.putExtra("citiesSelected",citiesChecked);
                    startActivityForResult(intent,1);
                }else{
                    Toast.makeText(getBaseContext(), "You should select exactly 5 cities", Toast.LENGTH_LONG).show();
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
                break;
            case "Chicago":
                chkChicago.setEnabled(false);
                break;
            case "Boston":
                chkBoston.setEnabled(false);
                break;
            case "Seattle":
                chkSeattle.setEnabled(false);
                break;
            case "Austin":
                chkAustin.setEnabled(false);
                break;
            case "Houston":
                chkHouston.setEnabled(false);
                break;
            case "Portland":
                chkPortland.setEnabled(false);
                break;
            case "Pittsburgh":
                chkPittsburgh.setEnabled(false);
                break;
            case "Orlando":
                chkOrlando.setEnabled(false);
                break;
            case "Tampa":
                chkTampa.setEnabled(false);
                break;
        }

    }
}
