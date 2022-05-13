package com.daelim;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class WebActivity extends AppCompatActivity {

    WebView webView;
    Button web_btn;
    EditText ed_web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        webView = findViewById(R.id.wb_wb);

        ed_web = findViewById(R.id.ed_web);
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);

        ed_web.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                System.out.println("ddd");
                System.out.println(i);
                switch(i) {
                    case EditorInfo
                            .IME_ACTION_SEARCH :
                        System.out.println("ccccc");
                        String uri = ed_web.getText().toString();
                        webView.loadUrl(uri);
                        ed_web.setText("");
                        break;
                }


                return false;
            }
        });










    }
}