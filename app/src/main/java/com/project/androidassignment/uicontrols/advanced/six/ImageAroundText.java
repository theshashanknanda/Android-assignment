package com.project.androidassignment.uicontrols.advanced.six;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.project.androidassignment.databinding.ActivityChangeBackgroundBinding;
import com.project.androidassignment.databinding.ActivityImageAroundTextBinding;

public class ImageAroundText extends AppCompatActivity {
    private ActivityImageAroundTextBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityImageAroundTextBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}