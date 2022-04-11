package com.project.androidassignment.sharedPreferences.advanced.one_two;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.project.androidassignment.databinding.ActivityCartBinding;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {
    private ActivityCartBinding binding;
    private List<ShopItem> items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ShopViewModel viewModel = new ViewModelProvider(this).get(ShopViewModel.class);
        items = new ArrayList<>();

        ShopAdapter adapter = new ShopAdapter(items, this);
        binding.recyclerView5.setAdapter(adapter);
        binding.recyclerView5.setLayoutManager(new LinearLayoutManager(this));

        items =  viewModel.getLiveData().getValue();
        adapter.notifyDataSetChanged();
    }
}