package com.project.androidassignment.room.advanced.two;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.project.androidassignment.databinding.ActivityCourseBinding;

import java.util.ArrayList;
import java.util.List;

public class CourseActivity extends AppCompatActivity {
    private ActivityCourseBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCourseBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        List<String> stringList = new ArrayList<>();
        stringList.add("Computer Science");
        stringList.add("Medical Science");
        stringList.add("Psychology");
        stringList.add("Social Science");

        CourseAdapter adapter = new CourseAdapter(this, stringList);
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}