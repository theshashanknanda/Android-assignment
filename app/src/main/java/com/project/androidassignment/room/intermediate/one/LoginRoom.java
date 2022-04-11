package com.project.androidassignment.room.intermediate.one;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.project.androidassignment.R;
import com.project.androidassignment.databinding.ActivityLoginRoomBinding;

public class LoginRoom extends AppCompatActivity {
    private ActivityLoginRoomBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginRoomBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportFragmentManager().beginTransaction().replace(R.id.roomContainer, new RegisterFragment()).commit();
    }
}