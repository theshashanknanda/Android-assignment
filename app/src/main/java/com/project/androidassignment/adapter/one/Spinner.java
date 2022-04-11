package com.project.androidassignment.adapter.one;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.project.androidassignment.databinding.ActivitySpinnerBinding;

import java.util.ArrayList;

public class Spinner extends AppCompatActivity {
    private ActivitySpinnerBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySpinnerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<String> list = new ArrayList<>();
        list.add("Ahmedabad");
        list.add("Delhi");
        list.add("Mumbai");
        list.add("Hyderabad");
        list.add("Kolkata");

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, list);
        binding.spinner.setAdapter(adapter);

        binding.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                binding.tv.setText(list.get(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}