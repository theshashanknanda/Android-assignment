package com.project.androidassignment.fragment.intermediate.two;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.project.androidassignment.R;
import com.project.androidassignment.databinding.ActivityLoginRegisterFragmentBinding;
import com.project.androidassignment.room.intermediate.one.RegisterFragment;

public class LoginRegisterFragment extends AppCompatActivity {
    private ActivityLoginRegisterFragmentBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginRegisterFragmentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, new RegisterFragment()).addToBackStack("register")
                .commit();
    }
}