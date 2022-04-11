package com.project.androidassignment.sharedPreferences.basic.one;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.project.androidassignment.databinding.ActivitySharedPrefDemoBinding;

public class SharedPrefDemo extends AppCompatActivity {
    private ActivitySharedPrefDemoBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySharedPrefDemoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SharedPreferences pref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        binding.sharedWriteButton.setOnClickListener(v -> {
            String data = binding.sharedED.getText().toString();
            editor.putString("key", data);
            editor.apply();
        });

        binding.sharedReadButton.setOnClickListener(v -> {
            String data = pref.getString("key", "No Text");
            binding.textView15.setText(data);
        });
    }
}