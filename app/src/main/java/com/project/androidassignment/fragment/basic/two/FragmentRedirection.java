package com.project.androidassignment.fragment.basic.two;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.project.androidassignment.R;
import com.project.androidassignment.databinding.ActivityFragmentRedirectionBinding;

public class FragmentRedirection extends AppCompatActivity {
    private ActivityFragmentRedirectionBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFragmentRedirectionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new FirstFragment()).commit();
    }
}