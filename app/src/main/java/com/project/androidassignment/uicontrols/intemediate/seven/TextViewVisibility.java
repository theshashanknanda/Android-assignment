package com.project.androidassignment.uicontrols.intemediate.seven;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.project.androidassignment.databinding.ActivityTextViewVisibilityBinding;

public class TextViewVisibility extends AppCompatActivity {
    private ActivityTextViewVisibilityBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTextViewVisibilityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.show.setOnClickListener(v -> {
            binding.textView4.setVisibility(View.VISIBLE);
        });

        binding.hide.setOnClickListener(v -> {
            binding.textView4.setVisibility(View.INVISIBLE);
        });
    }
}