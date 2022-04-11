package com.project.androidassignment.uicontrols.advanced.three;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;

import com.google.android.material.snackbar.Snackbar;
import com.project.androidassignment.databinding.ActivityFontSizeBinding;

public class FontSizeActivity extends AppCompatActivity {
    private ActivityFontSizeBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFontSizeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.textView5.setTextSize(TypedValue.COMPLEX_UNIT_PX, 100f);
        Snackbar.make(binding.getRoot(), String.valueOf(binding.textView5.getTextSize()), Snackbar.LENGTH_SHORT).show();

        binding.minus.setOnClickListener(v -> {
            binding.textView5.setTextSize(TypedValue.COMPLEX_UNIT_PX,binding.textView5.getTextSize() -1f);
            Snackbar.make(binding.getRoot(), String.valueOf(binding.textView5.getTextSize()), Snackbar.LENGTH_SHORT).show();
            Log.i("size", "minus");
        });

        binding.plus.setOnClickListener(v -> {
            binding.textView5.setTextSize(TypedValue.COMPLEX_UNIT_PX ,binding.textView5.getTextSize() + 1f);
            Log.i("size", "plus");
            Snackbar.make(binding.getRoot(), String.valueOf(binding.textView5.getTextSize()), Snackbar.LENGTH_SHORT).show();
        });
    }
}