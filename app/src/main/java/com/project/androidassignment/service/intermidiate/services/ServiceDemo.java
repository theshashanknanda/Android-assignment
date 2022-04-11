package com.project.androidassignment.service.intermidiate.services;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.project.androidassignment.databinding.ActivityServiceDemoBinding;

public class ServiceDemo extends AppCompatActivity {
    private ActivityServiceDemoBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityServiceDemoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.startServiceButton.setOnClickListener(v -> {
            Intent i = new Intent(this, MyService.class);
            startService(i);
        });

        binding.stopServiceButton.setOnClickListener(v -> {
            stopService(new Intent(this, MyService.class));
        });
    }
}