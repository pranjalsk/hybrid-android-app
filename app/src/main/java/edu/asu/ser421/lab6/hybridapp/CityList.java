package edu.asu.ser421.lab6.hybridapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;
public class CityList extends AppCompatActivity {

    ListView lv;
    Model[] modelItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_list);
        lv = (ListView) findViewById(R.id.listView1);
        modelItems = new Model[5];
        modelItems[0] = new Model("Denver", 0);
        modelItems[1] = new Model("Boston", 1);
        modelItems[2] = new Model("Seattle", 1);
        modelItems[3] = new Model("Chicago", 0);
        modelItems[4] = new Model("Austin", 1);
        modelItems[5] = new Model("Houston", 0);
        modelItems[6] = new Model("Nashville", 1);
        modelItems[7] = new Model("Pittsburgh", 1);
        modelItems[8] = new Model("Orlando", 0);
        modelItems[9] = new Model("Tampa", 1);
        CustomAdapter adapter = new CustomAdapter(this, modelItems);
        lv.setAdapter(adapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}

