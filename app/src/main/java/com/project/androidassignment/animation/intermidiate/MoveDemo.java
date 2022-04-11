package com.project.androidassignment.animation.intermidiate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.project.androidassignment.R;
import com.project.androidassignment.databinding.ActivityMoveDemoBinding;

public class MoveDemo extends AppCompatActivity {
    private ActivityMoveDemoBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMoveDemoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Animation move = AnimationUtils.loadAnimation(this, R.anim.move);
        binding.textView19.startAnimation(move);
    }
}