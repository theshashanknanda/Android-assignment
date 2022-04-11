package com.project.androidassignment.activity.advanced.one;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.project.androidassignment.databinding.ActivityPersonDataBinding;

public class PersonData extends AppCompatActivity {

    private ActivityPersonDataBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPersonDataBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Model model = new Model();
        model = (Model) getIntent().getSerializableExtra("data");

        binding.personDataTV.setText(model.toString());
    }
}