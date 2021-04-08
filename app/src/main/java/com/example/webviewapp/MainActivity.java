package com.example.webviewapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private WebView my_WebView;


    @SuppressLint("SetJavaScriptEnabled")
    public void showWebPage(String where){ //retrieve variable where

        if (where == "external"){
            my_WebView.loadUrl("https://student.his.se"); // Loads external URL
        }

        else if (where == "internal"){
            my_WebView.loadUrl("file:///android_asset/about.html"); // Loads internal HTML file
        }

    }



    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        my_WebView = findViewById(R.id.my_webview); //Connects my_webview to the content webview ID
        my_WebView.getSettings().setJavaScriptEnabled(true); //Enables javascript in my_WebView

        WebViewClient my_WebViewClient = new WebViewClient();
        my_WebView.setWebViewClient(my_WebViewClient);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetJavaScriptEnabled")
            @Override
            public void onClick(View view) {
                my_WebView.loadUrl("https://mail.his.se"); // Loads external URL
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_external_web) {
        showWebPage("external"); // Run function and pass "external".
        }

        if (id == R.id.action_internal_web) {
        showWebPage("internal"); // Run function and pass "internal".
        }

        return super.onOptionsItemSelected(item);
    }
}
