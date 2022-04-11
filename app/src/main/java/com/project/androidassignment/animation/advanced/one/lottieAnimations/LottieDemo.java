package com.project.androidassignment.animation.advanced.one.lottieAnimations;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.project.androidassignment.animation.intermidiate.one.Rotation;
import com.project.androidassignment.databinding.ActivityLottieDemoBinding;

public class LottieDemo extends AppCompatActivity {
    private ActivityLottieDemoBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLottieDemoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(LottieDemo.this, Rotation.class));
            }
        }, 2000);

    }
}