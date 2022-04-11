package com.project.androidassignment.room.advanced.two;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.project.androidassignment.databinding.ActivitySchoolSplashScreenBinding;
import com.project.androidassignment.room.intermediate.one.LoginRoom;

public class SchoolSplashScreen extends AppCompatActivity {
    private ActivitySchoolSplashScreenBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySchoolSplashScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SchoolSplashScreen.this, LoginRoom.class));
            }
        }, 3000);
    }
}