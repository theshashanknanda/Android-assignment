package com.project.androidassignment.activity.advanced.two;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.project.androidassignment.databinding.ActivityCalculatorBinding;

public class Calculator extends AppCompatActivity {

    private ActivityCalculatorBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCalculatorBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.add.setOnClickListener(v -> {
            int n1 = Integer.parseInt(binding.num1.getText().toString());
            int n2 = Integer.parseInt(binding.num2.getText().toString());
            Toast.makeText(this, String.valueOf(n1+n2), Toast.LENGTH_LONG).show();
        });

        binding.subtract.setOnClickListener(v -> {
            int n1 = Integer.parseInt(binding.num1.getText().toString());
            int n2 = Integer.parseInt(binding.num2.getText().toString());
            Toast.makeText(this, String.valueOf(n1-n2), Toast.LENGTH_LONG).show();
        });

        binding.multiply.setOnClickListener(v -> {
            int n1 = Integer.parseInt(binding.num1.getText().toString());
            int n2 = Integer.parseInt(binding.num2.getText().toString());
            Toast.makeText(this, String.valueOf(n1*n2), Toast.LENGTH_LONG).show();
        });

        binding.divide.setOnClickListener(v -> {
            int n1 = Integer.parseInt(binding.num1.getText().toString());
            int n2 = Integer.parseInt(binding.num2.getText().toString());
            Toast.makeText(this, String.valueOf(n1/n2), Toast.LENGTH_LONG).show();
        });
    }
}