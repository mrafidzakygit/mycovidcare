package com.example.mycovidcarefinal;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Berita extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berita);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        //WebView
        WebView webView = (WebView) findViewById(R.id.beritacovid);
        webView.loadUrl("https://covid19.go.id/p/berita");
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
    }
}