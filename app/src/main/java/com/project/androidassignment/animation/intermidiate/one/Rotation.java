package com.project.androidassignment.animation.intermidiate.one;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.project.androidassignment.R;
import com.project.androidassignment.databinding.ActivityRotationBinding;

public class Rotation extends AppCompatActivity {
    private ActivityRotationBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRotationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Animation rotate = AnimationUtils.loadAnimation(this, R.anim.rotate);
        binding.appCompatButton8.setOnClickListener(v -> {
            binding.rotateTV.startAnimation(rotate);
        });
    }
}