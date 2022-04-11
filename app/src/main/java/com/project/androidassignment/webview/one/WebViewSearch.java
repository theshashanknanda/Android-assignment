package com.project.androidassignment.webview.one;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebViewClient;

import com.project.androidassignment.databinding.ActivityWebViewSearchBinding;

public class WebViewSearch extends AppCompatActivity {
    private ActivityWebViewSearchBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWebViewSearchBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.button.setOnClickListener(v -> {
            binding.webView.setWebViewClient(new WebViewClient());
            binding.webView.getSettings().setJavaScriptEnabled(true);
            binding.webView.loadUrl(binding.editText.getText().toString());
        });
    }
}