package com.project.androidassignment.adapter.advanced.one;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.project.androidassignment.R;
import com.project.androidassignment.databinding.ActivityCustomAdapterBinding;

import java.util.ArrayList;

public class CustomAdapter extends AppCompatActivity {
    private ActivityCustomAdapterBinding binding;
    private ArrayList<Employee> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCustomAdapterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        list = new ArrayList<>();

        list.add(new Employee(R.drawable.person, "Employee 1", "CEO", "20th Aug, 2020"));
        list.add(new Employee(R.drawable.person, "Employee 2", "CEO", "20th Aug, 2020"));
        list.add(new Employee(R.drawable.person, "Employee 3", "CEO", "20th Aug, 2020"));
        list.add(new Employee(R.drawable.person, "Employee 4", "CEO", "20th Aug, 2020"));
        list.add(new Employee(R.drawable.person, "Employee 5", "CEO", "20th Aug, 2020"));

        CustomAdapterDemo adapter = new CustomAdapterDemo(this, list);
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}