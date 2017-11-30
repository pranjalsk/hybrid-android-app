package edu.asu.ser421.lab6.hybridapp;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import android.webkit.JavascriptInterface;
import android.content.Intent;
import java.util.ArrayList;

public class WebviewActivity extends AppCompatActivity {
    private String tag = "mytag";
    static WebView browser;
    ArrayList<String> citesList;
    public static String thirdCity="";

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
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(true);
        webSettings.setSupportZoom(true);



        //collect data coming from previous activity
        citesList = (ArrayList<String>) getIntent().getSerializableExtra("citiesSelected");
        System.out.println("cities: "+citesList.toString());

        // need this
        browser.setWebViewClient(new WebViewClient() {
            public void onPageFinished(WebView view, String url) {
                browser.evaluateJavascript("populateCitiesDropdown(\""+citesList.get(0)+"\",\"" + citesList.get(1) + "\",\"" + citesList.get(2) + "\",\"" + citesList.get(3) + "\",\"" + citesList.get(4) + "\")", null);
                browser.evaluateJavascript("selectedThirdCity(\""+citesList.get(0)+"\")",null);
            }
        });

        browser.addJavascriptInterface(new WebAppInterface(this.getApplicationContext()), "Android");
        browser.loadUrl("file:///android_asset/www/index.html");


    }


    @Override
    public void onBackPressed() {
        Log.i(tag, "back button pressed");
        //super.onBackPressed();
        Intent returnIntent = new Intent();
        returnIntent.putExtra("result",thirdCity);
        setResult(Activity.RESULT_OK,returnIntent);
        finish();
    }


}

class WebAppInterface {
    private Context mContext;

    WebAppInterface(Context c) {
        mContext = c;
    }

    @JavascriptInterface
    public void getThirdCity(String name) {
        WebviewActivity.thirdCity = name;
        Toast.makeText(mContext.getApplicationContext(), "ThirdCIty: "+WebviewActivity.thirdCity, Toast.LENGTH_LONG).show();
    }
}
