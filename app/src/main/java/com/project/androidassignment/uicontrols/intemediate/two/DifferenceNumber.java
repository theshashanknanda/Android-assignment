package com.project.androidassignment.uicontrols.intemediate.two;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.project.androidassignment.databinding.ActivityDifferenceNumberBinding;

public class DifferenceNumber extends AppCompatActivity {
    private ActivityDifferenceNumberBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDifferenceNumberBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int n1 = getIntent().getIntExtra("num1", 0);
        int n2 = getIntent().getIntExtra("num2", 0);

        while(n1 <= n2)
        {
            String s = binding.diffTV.getText().toString();
            binding.diffTV.setText(s + " " + String.valueOf(n1));
            n1++;
        }
    }
}