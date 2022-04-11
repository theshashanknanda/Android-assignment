package com.project.androidassignment.storage.five;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.project.androidassignment.databinding.ActivityHtmlfromAssets2Binding;

public class HTMLFromAssets extends AppCompatActivity {
    private ActivityHtmlfromAssets2Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHtmlfromAssets2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.webView.loadUrl("file:///android_asset/index.html");
    }
}