package com.example.sangameswaran.test2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

/**
 * Created by Sangameswaran on 10-10-2016.
 */


    public class WebActivity extends AppCompatActivity {
        WebView wb;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_web);
            wb= (WebView) findViewById(R.id.wer);
            wb.setWebChromeClient(new WebChromeClient());
            wb.getSettings().setJavaScriptEnabled(true);
            wb.loadUrl("http://www.wolfram.com/mathematica/new-in-11/?src=google&412");
        }
    }


