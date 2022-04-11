package com.project.androidassignment.fragment.advanced.one;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.project.androidassignment.R;
import com.project.androidassignment.databinding.ActivityPassingDataBinding;

public class PassingData extends AppCompatActivity {
    private ActivityPassingDataBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPassingDataBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportFragmentManager().beginTransaction().add(R.id.fView, new Fragment1()).commit();
    }
}