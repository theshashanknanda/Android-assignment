package com.project.androidassignment.activity.advanced.one;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.project.androidassignment.R;
import com.project.androidassignment.databinding.ActivityPersonInputBinding;

public class PersonInput extends AppCompatActivity {

    private ActivityPersonInputBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPersonInputBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonSend.setOnClickListener(v -> {
            String name = binding.nameTV.getText().toString();
            String age = binding.ageTV.getText().toString();
            String weight = binding.weightTV.getText().toString();

            Model model = new Model(name, age, weight);

            Intent intent = new Intent(PersonInput.this, PersonData.class);
            intent.putExtra("data", model);
            startActivity(intent);
        });
    }
}