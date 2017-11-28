package edu.asu.ser421.lab6.hybridapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.ArrayList;

public class CityInfoWebview extends AppCompatActivity {

    WebView browser;
    String cityUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_info_webview);

        browser = (WebView) findViewById(R.id.cityInfoWebView);

        browser.setWebContentsDebuggingEnabled(true);

        browser.setWebViewClient(new CustomWebViewClient());

        // enable JS
        WebSettings webSettings = browser.getSettings();
        webSettings.setJavaScriptEnabled(false);
        webSettings.setAllowUniversalAccessFromFileURLs(true);
        webSettings.setDomStorageEnabled(true);


        //collect data coming from previous activity
        cityUrl = getIntent().getStringExtra("cityName");
        System.out.println("cities: "+cityUrl);


        browser.loadUrl("http://www.city-data.com/cityw/"+cityUrl+".html");

    }
}
class CustomWebViewClient extends WebViewClient {
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        return true;
    }
}