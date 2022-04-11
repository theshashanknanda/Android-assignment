package com.project.androidassignment.animation.intermidiate.two;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.project.androidassignment.R;
import com.project.androidassignment.databinding.ActivityBlinkAnimBinding;

public class BlinkAnim extends AppCompatActivity {
    private ActivityBlinkAnimBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBlinkAnimBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Animation blink = AnimationUtils.loadAnimation(this, R.anim.alpha);
        binding.startBtn.setOnClickListener(v -> {
            binding.imageView.startAnimation(blink);
        });
    }
}