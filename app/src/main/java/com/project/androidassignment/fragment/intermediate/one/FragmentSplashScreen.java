package com.project.androidassignment.fragment.intermediate.one;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.project.androidassignment.R;
import com.project.androidassignment.databinding.ActivityFragmentSplashScreenBinding;
import com.project.androidassignment.fragment.basic.two.FirstFragment;

public class FragmentSplashScreen extends AppCompatActivity {
    private ActivityFragmentSplashScreenBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFragmentSplashScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportFragmentManager().beginTransaction().replace(R.id.splashContainer, new SplashFragment()).commit();

    }
}