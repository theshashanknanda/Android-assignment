package com.project.androidassignment.webview.three;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.webkit.WebViewClient;

import com.project.androidassignment.databinding.ActivityActivityToWebViewBinding;

public class ActivityActivityToWebView extends AppCompatActivity {
    private ActivityActivityToWebViewBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityActivityToWebViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        String html = "<html> <body> <h1>Title</h1> <p>Hello from HTML</p> </body> </html>";
        binding.webView2.setWebViewClient(new WebViewClient());
        binding.webView2.loadData(html, "text/html", null);
    }
}