package edu.asu.ser421.lab6.hybridapp;

import android.app.Activity;
import android.webkit.WebView;

/**
 * Created by pranjal on 11/26/2017.
 */

public class JsHandler {

    Activity activity;
    String TAG = "JsHandler";
    WebView webView;

    public JsHandler(Activity _contxt,WebView _webView) {
        activity = _contxt;
        webView = _webView;
    }

    public void javaFnCall(String city1, String city2,String city3,String city4,String city5) {


        final String webUrl = "javascript:populateCitiesDropdown(city1,city2,city3,city4,city5)";
        // Add this to avoid android.view.windowmanager$badtokenexception unable to add window
        if(!activity.isFinishing())
            // loadurl on UI main thread
            activity.runOnUiThread(new Runnable() {

                @Override
                public void run() {
                    webView.loadUrl(webUrl);
                }
            });
    }




}
