package edu.asu.ser421.lab6.hybridapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private JsHandler _jsHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView weatherwebview = (WebView) findViewById(R.id.weatherWebView);

        weatherwebview.setWebViewClient(new WebViewClient());

        weatherwebview.setHorizontalScrollBarEnabled(true);
        weatherwebview.setVerticalScrollBarEnabled(true);
        weatherwebview.getSettings().setJavaScriptEnabled(true);


        weatherwebview.getSettings().setDomStorageEnabled(true);
        weatherwebview.getSettings().setAllowContentAccess(true);
        weatherwebview.getSettings().setAllowFileAccess(true);
        weatherwebview.getSettings().setAppCacheEnabled(true);
        weatherwebview.getSettings().setBuiltInZoomControls(true);
        weatherwebview.getSettings().setDatabaseEnabled(true);
        weatherwebview.getSettings().setDisplayZoomControls(true);
        weatherwebview.getSettings().setGeolocationEnabled(true);
        weatherwebview.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        weatherwebview.getSettings().setLoadsImagesAutomatically(true);
        weatherwebview.getSettings().setSaveFormData(true);
        weatherwebview.getSettings().setSupportMultipleWindows(true);
        weatherwebview.getSettings().setSupportZoom(true);

        ArrayList<String> citesList = (ArrayList<String>) getIntent().getSerializableExtra("stringArray");
        System.out.println("cities: "+citesList.toString());
        weatherwebview.loadUrl("javascript:populateCitiesDropdown(citesList.get(0),citesList.get(1),citesList.get(2),citesList.get(3),citesList.get(4))");
        weatherwebview.loadUrl("http://10.0.2.2:8888/");
        //_jsHandler = new JsHandler(this, weatherwebview);
        //_jsHandler.javaFnCall(citesList.get(0),citesList.get(1),citesList.get(2),citesList.get(3),citesList.get(4));

    }
}
