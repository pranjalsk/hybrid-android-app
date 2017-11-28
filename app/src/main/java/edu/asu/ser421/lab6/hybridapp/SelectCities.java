package edu.asu.ser421.lab6.hybridapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.ArrayList;

public class SelectCities extends AppCompatActivity {

    private CheckBox chkDenver, chkChicago, chkBoston,chkSeattle,chkAustin,chkHouston,chkNashville,
            chkPittsburgh,chkOrlando,chkTampa;
    private Button showWeather;
    ArrayList<String> citiesChecked;

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
        chkNashville = (CheckBox) findViewById(R.id.chkNashville);
        chkPittsburgh = (CheckBox) findViewById(R.id.chkPittsburgh);
        chkOrlando = (CheckBox) findViewById(R.id.chkOrlando);
        chkTampa = (CheckBox) findViewById(R.id.chkTampa);


        showWeather = (Button) findViewById(R.id.showWeather);



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
                if(chkNashville.isChecked()) citiesChecked.add("Nashville");
                if(chkPittsburgh.isChecked()) citiesChecked.add("Pittsburgh");
                if(chkOrlando.isChecked()) citiesChecked.add("Orlando");
                if(chkTampa.isChecked()) citiesChecked.add("Tampa");

                Toast.makeText(SelectCities.this, citiesChecked.toString(),
                        Toast.LENGTH_SHORT).show();

                if(citiesChecked.size()==5){
                    Intent intent = new Intent(SelectCities.this, WebviewActivity.class);
                    intent.putExtra("citiesSelected",citiesChecked);
                    startActivity(intent);
                }else{
                    Toast.makeText(getBaseContext(), "You should select exactly 5 cities", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
