package com.example.web_googlemap_ex8;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity2 extends AppCompatActivity {
    WebView w1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        w1=(WebView) findViewById(R.id.web);

        Bundle b=getIntent().getExtras();
        String latitude=b.getString("lat");
        String longitude=b.getString("lon");

        WebSettings ws=w1.getSettings();
        ws.setJavaScriptEnabled(true);
        w1.loadUrl("https://www.google.co.in/maps/@"+latitude+","+longitude+",16.08z");
        w1.setWebViewClient(new WebViewClient());

    }
}