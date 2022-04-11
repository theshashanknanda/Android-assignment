package com.project.androidassignment.menu.basic.one;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;

import com.project.androidassignment.R;
import com.project.androidassignment.databinding.ActivityOptionsMenuDemoBinding;

public class OptionsMenuDemo extends AppCompatActivity {
    private ActivityOptionsMenuDemoBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOptionsMenuDemoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}