package com.project.androidassignment.adapter.advanced.three;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;

import com.project.androidassignment.R;
import com.project.androidassignment.databinding.ActivityGridViewBinding;

import java.util.ArrayList;
import java.util.List;

public class GridView extends AppCompatActivity {
    private ActivityGridViewBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGridViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        List<Integer> list = new ArrayList<>();
        list.add(R.drawable.person);
        list.add(R.drawable.person);
        list.add(R.drawable.person);
        list.add(R.drawable.person);
        list.add(R.drawable.person);
        list.add(R.drawable.person);
        list.add(R.drawable.person);
        list.add(R.drawable.person);
        list.add(R.drawable.person);
        list.add(R.drawable.person);
        list.add(R.drawable.person);

        GridViewAdapter adapter = new GridViewAdapter(this, list);

        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
    }
}