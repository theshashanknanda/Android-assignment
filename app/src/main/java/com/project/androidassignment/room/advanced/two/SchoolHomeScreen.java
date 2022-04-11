package com.project.androidassignment.room.advanced.two;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.project.androidassignment.databinding.ActivitySchoolHomeScreenBinding;
import com.project.androidassignment.room.intermediate.one.LoginRoom;

public class SchoolHomeScreen extends AppCompatActivity {
    private ActivitySchoolHomeScreenBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySchoolHomeScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SharedPreferences preferences = getSharedPreferences("login", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        binding.logoutButton.setOnClickListener(v -> {
            editor.putBoolean("state", false);
            editor.apply();

            startActivity(new Intent(SchoolHomeScreen.this, LoginRoom.class));
        });

        binding.galleryButton.setOnClickListener(v -> {
            startActivity(new Intent(this, GalleryActivity.class));
        });

        binding.schoolInformationButton.setOnClickListener(v -> {
            startActivity(new Intent(this, CourseActivity.class));
        });

        binding.facultyButton.setOnClickListener(v -> {
            startActivity(new Intent(this, FacultyActivity.class));
        });

        binding.aboutUsButton.setOnClickListener(v -> {
            startActivity(new Intent(this, AboutUsActivity.class));
        });
    }
}
