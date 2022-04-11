package com.project.androidassignment.uicontrols.intemediate.five;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebViewClient;

import com.project.androidassignment.databinding.ActivityWebViewDemoBinding;

public class WebViewDemo extends AppCompatActivity {
    private ActivityWebViewDemoBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWebViewDemoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.webview.setWebViewClient(new WebViewClient());
        binding.webview.getSettings().setJavaScriptEnabled(true);
        binding.webview.loadUrl("https://www.google.com");
    }

    @Override
    public void onBackPressed() {
        if(binding.webview.canGoBack())
            binding.webview.goBack();
        else
            super.onBackPressed();
    }
}