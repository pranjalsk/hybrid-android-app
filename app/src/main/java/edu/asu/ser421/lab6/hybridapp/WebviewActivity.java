package edu.asu.ser421.lab6.hybridapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.ArrayList;

public class WebviewActivity extends AppCompatActivity {

    WebView browser;
    ArrayList<String> citesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        browser = (WebView) findViewById(R.id.weatherWebView);

        browser.setWebContentsDebuggingEnabled(true);

        browser.setWebChromeClient(new WebChromeClient());

        // enable JS
        WebSettings webSettings = browser.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAllowUniversalAccessFromFileURLs(true);
        webSettings.setDomStorageEnabled(true);

        //collect data coming from previous activity
        citesList = (ArrayList<String>) getIntent().getSerializableExtra("citiesSelected");
        System.out.println("cities: "+citesList.toString());

        // need this
        browser.setWebViewClient(new WebViewClient() {
            public void onPageFinished(WebView view, String url) {
                browser.evaluateJavascript("populateCitiesDropdown(\""+citesList.get(0)+"\",\"" + citesList.get(1) + "\",\"" + citesList.get(2) + "\",\"" + citesList.get(3) + "\",\"" + citesList.get(4) + "\")", null);
            }
        });


        browser.loadUrl("file:///android_asset/www/index.html");



    }
}
