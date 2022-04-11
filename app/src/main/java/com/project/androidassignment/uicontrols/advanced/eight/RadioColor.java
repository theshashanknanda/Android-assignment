package com.project.androidassignment.uicontrols.advanced.eight;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioGroup;

import com.google.android.material.snackbar.Snackbar;
import com.project.androidassignment.databinding.ActivityRadioColorBinding;

public class RadioColor extends AppCompatActivity {
    private ActivityRadioColorBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRadioColorBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.red.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    binding.layout.setBackgroundColor(Color.RED);
            }
        });

        binding.green.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    binding.layout.setBackgroundColor(Color.GREEN);
            }
        });

        binding.blue.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    binding.layout.setBackgroundColor(Color.BLUE);
            }
        });
    }
}