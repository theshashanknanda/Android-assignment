package com.project.androidassignment.animation.intermidiate.four;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.project.androidassignment.R;
import com.project.androidassignment.databinding.ActivityScaleDemoBinding;

public class ScaleDemo extends AppCompatActivity {
    private ActivityScaleDemoBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityScaleDemoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Animation scale = AnimationUtils.loadAnimation(this, R.anim.scale);
        binding.textView20.setAnimation(scale);
    }
}