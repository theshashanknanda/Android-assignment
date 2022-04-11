
package com.project.androidassignment.sharedPreferences.intermediate.two;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.project.androidassignment.databinding.ActivityLoginSessionDemopBinding;

public class LoginSessionDemop extends AppCompatActivity {
    private ActivityLoginSessionDemopBinding binding;
    private SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginSessionDemopBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        preferences = getSharedPreferences("login", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        boolean status = preferences.getBoolean("status", false);
        if(status){
            startActivity(new Intent(this, Dashboard.class));
        }

        binding.appCompatButton3.setOnClickListener(v -> {
            editor.putBoolean("status", true);
            editor.apply();

            startActivity(new Intent(this, Dashboard.class));
        });
    }
}