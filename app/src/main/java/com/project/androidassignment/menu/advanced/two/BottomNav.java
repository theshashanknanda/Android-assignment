package com.project.androidassignment.menu.advanced.two;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.project.androidassignment.R;
import com.project.androidassignment.databinding.ActivityBottomNavBinding;

public class BottomNav extends AppCompatActivity {
    private ActivityBottomNavBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBottomNavBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportFragmentManager().beginTransaction().add(R.id.containerView, new GalleryFragment()).commit();

        binding.bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.gallery:
                    getSupportFragmentManager().beginTransaction().replace(R.id.containerView, new GalleryFragment()).commit();
                    break;

                case R.id.video:
                    getSupportFragmentManager().beginTransaction().replace(R.id.containerView, new VideoFragment()).commit();
                    break;

                case R.id.audio:
                    getSupportFragmentManager().beginTransaction().replace(R.id.containerView, new AudioFragment()).commit();
                    break;
            }
            return false;
        });
    }
}