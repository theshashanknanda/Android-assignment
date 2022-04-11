package com.project.androidassignment.menu.intermediate.one;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.project.androidassignment.databinding.ActivityPopupMenuBinding;

import java.util.ArrayList;
import java.util.List;

public class PopupMenu extends AppCompatActivity {
    private ActivityPopupMenuBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPopupMenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        List<String> stringList = new ArrayList<>();
        stringList.add("Item 1");
        stringList.add("Item 2");
        stringList.add("Item 3");
        stringList.add("Item 4");
        stringList.add("Item 5");

        MenuAdapter adapter = new MenuAdapter(stringList, this);
        binding.recyclerView3.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView3.setAdapter(adapter);
    }
}