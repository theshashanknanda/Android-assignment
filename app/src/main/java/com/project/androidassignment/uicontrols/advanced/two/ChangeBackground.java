package com.project.androidassignment.uicontrols.advanced.two;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.project.androidassignment.databinding.ActivityChangeBackgroundBinding;

public class ChangeBackground extends AppCompatActivity {
    private ActivityChangeBackgroundBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChangeBackgroundBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.appCompatButton2.setOnClickListener(v -> {
            binding.background.setBackgroundColor(Color.MAGENTA);
        });
    }
}