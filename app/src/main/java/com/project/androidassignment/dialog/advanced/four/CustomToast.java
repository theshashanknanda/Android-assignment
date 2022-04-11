package com.project.androidassignment.dialog.advanced.four;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.project.androidassignment.databinding.ActivityCustomToastBinding;
import com.project.androidassignment.databinding.ToastviewBinding;

public class CustomToast extends AppCompatActivity {
    private ActivityCustomToastBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCustomToastBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toast toast = new Toast(this);
        toast.setView(ToastviewBinding.inflate(getLayoutInflater()).getRoot());
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.show();
    }
}