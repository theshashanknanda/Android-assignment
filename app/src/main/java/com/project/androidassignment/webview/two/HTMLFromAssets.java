package com.project.androidassignment.webview.two;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebViewClient;

import com.project.androidassignment.databinding.ActivityHtmlfromAssetsBinding;

public class HTMLFromAssets extends AppCompatActivity {
    private ActivityHtmlfromAssetsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHtmlfromAssetsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.webViewId.setWebViewClient(new WebViewClient());
        binding.webViewId.loadUrl("file:///android_asset/index.html");
    }
}