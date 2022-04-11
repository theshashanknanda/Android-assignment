package com.project.androidassignment.uicontrols.intemediate.two;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.project.androidassignment.databinding.ActivityDifferenceInputBinding;

public class DifferenceInput extends AppCompatActivity {

    private ActivityDifferenceInputBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDifferenceInputBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.next.setOnClickListener(v -> {
            Intent i = new Intent(DifferenceInput.this, DifferenceNumber.class);
            int n1 = Integer.parseInt(binding.diffnum1.getText().toString());
            int n2 = Integer.parseInt(binding.diffnum2.getText().toString());
            i.putExtra("num1", n1);
            i.putExtra("num2", n2);
            startActivity(i);
        });
    }
}