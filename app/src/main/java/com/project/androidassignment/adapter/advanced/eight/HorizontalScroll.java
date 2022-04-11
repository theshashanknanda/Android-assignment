package com.project.androidassignment.adapter.advanced.eight;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.project.androidassignment.R;
import com.project.androidassignment.adapter.advanced.three.GridViewAdapter;
import com.project.androidassignment.databinding.ActivityHorizontalScrollBinding;

import java.util.ArrayList;

public class HorizontalScroll extends AppCompatActivity {
    private ActivityHorizontalScrollBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHorizontalScrollBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<Integer> list = new ArrayList<>();
        list.add(R.drawable.person);
        list.add(R.drawable.person);
        list.add(R.drawable.person);
        list.add(R.drawable.person);
        list.add(R.drawable.person);
        list.add(R.drawable.person);

        GridViewAdapter adapter = new GridViewAdapter(this, list);
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    }
}