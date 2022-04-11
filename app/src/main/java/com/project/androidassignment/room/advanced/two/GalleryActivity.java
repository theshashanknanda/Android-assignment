package com.project.androidassignment.room.advanced.two;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;

import com.project.androidassignment.databinding.ActivityGalleryBinding;

public class GalleryActivity extends AppCompatActivity {
    private ActivityGalleryBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGalleryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        GalleryAdapter adapter = new GalleryAdapter(this);
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
    }
}