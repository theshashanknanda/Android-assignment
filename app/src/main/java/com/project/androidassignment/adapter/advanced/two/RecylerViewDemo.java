package com.project.androidassignment.adapter.advanced.two;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.project.androidassignment.adapter.advanced.one.Employee;
import com.project.androidassignment.databinding.ActivityRecylerViewDemoBinding;

import java.util.ArrayList;
import java.util.List;

public class RecylerViewDemo extends AppCompatActivity {
    private ActivityRecylerViewDemoBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRecylerViewDemoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Name 1", "CEO", "20th August"));
        employeeList.add(new Employee("Name 2", "MD", "22th August"));
        employeeList.add(new Employee("Name 3", "HR", "5th September"));
        employeeList.add(new Employee("Name 4", "Chief", "38th October"));
        employeeList.add(new Employee("Name 5", "Worker", "3rd November"));

        EmployeeAdapter adapter = new EmployeeAdapter(this, employeeList);

        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}