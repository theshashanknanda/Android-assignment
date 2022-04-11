package com.project.androidassignment.sharedPreferences.intermediate.two;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.project.androidassignment.databinding.ActivityDashboardBinding;

public class Dashboard extends AppCompatActivity {
    private ActivityDashboardBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.appCompatButton4.setOnClickListener(v -> {
            SharedPreferences preferences = getSharedPreferences("login", MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();

            editor.putBoolean("status", false);
            editor.apply();

            startActivity(new Intent(Dashboard.this, LoginSessionDemop.class));
            finish();
        });
    }
}