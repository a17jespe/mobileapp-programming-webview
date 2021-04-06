package com.example.webviewapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    public void showExternalWebPage(){
        // TODO: Add your code for showing external web page here

    }

    public void showInternalWebPage(){
        // TODO: Add your code for showing internal web page here
    }

    private WebView my_WebView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetJavaScriptEnabled")
            @Override
            public void onClick(View view) {
                WebView my_WebView = findViewById(R.id.my_webview); //Connects my_webview to the content webview ID
                WebViewClient my_WebViewClient = new WebViewClient();
                my_WebView.setWebViewClient(my_WebViewClient);
                my_WebView.getSettings().setJavaScriptEnabled(true); //Enables javascript in my_WebView
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

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_external_web) {

            WebView my_WebView = findViewById(R.id.my_webview); //Connects my_webview to the content webview ID
            my_WebView.getSettings().setJavaScriptEnabled(true); //Enables javascript in my_WebView
            my_WebView.loadUrl("https://student.his.se"); // Loads external URL

        }

        if (id == R.id.action_internal_web) {

            WebView my_WebView = findViewById(R.id.my_webview); //Connects my_webview to the content webview ID
            my_WebView.getSettings().setJavaScriptEnabled(true); //Enables javascript in my_WebView
            my_WebView.loadUrl("file:///android_asset/about.html"); // Loads internal HTML file

        }

        return super.onOptionsItemSelected(item);
    }
}
