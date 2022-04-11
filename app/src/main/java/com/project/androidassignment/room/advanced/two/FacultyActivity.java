package com.project.androidassignment.room.advanced.two;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.project.androidassignment.databinding.ActivityFacultyBinding;

public class FacultyActivity extends AppCompatActivity {
    private ActivityFacultyBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFacultyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}