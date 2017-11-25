package edu.asu.ser421.lab6.hybridapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView weatherwebview = (WebView) findViewById(R.id.weatherWebView);

        weatherwebview.setWebViewClient(new WebViewClient());

        weatherwebview.setHorizontalScrollBarEnabled(true);
        weatherwebview.setVerticalScrollBarEnabled(true);
        weatherwebview.setWebContentsDebuggingEnabled(true);
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

        weatherwebview.loadUrl("http://10.0.2.2:8888/");



    }
}
