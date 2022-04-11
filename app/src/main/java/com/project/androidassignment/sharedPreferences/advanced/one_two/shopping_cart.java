package com.project.androidassignment.sharedPreferences.advanced.one_two;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.project.androidassignment.R;
import com.project.androidassignment.databinding.ActivityShoppingCartBinding;

import java.util.ArrayList;
import java.util.List;

public class shopping_cart extends AppCompatActivity {
    private ActivityShoppingCartBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityShoppingCartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        List<ShopItem> itemList = new ArrayList<>();
        itemList.add(new ShopItem("Apples"));
        itemList.add(new ShopItem("Fridge"));
        itemList.add(new ShopItem("Oven"));
        itemList.add(new ShopItem("Bat"));
        itemList.add(new ShopItem("Iphone 13"));

        ShopAdapter adapter = new ShopAdapter(itemList, this);
        binding.recyclerView4.setAdapter(adapter);
        binding.recyclerView4.setLayoutManager(new LinearLayoutManager(this));

        ShopViewModel model = new ViewModelProvider(this).get(ShopViewModel.class);
        model.add(new ShopItem("Item 1"));
        model.add(new ShopItem("Item 2"));
        model.add(new ShopItem("Item 3"));

        model.getLiveData().observe(this, new Observer<List<ShopItem>>() {
            @Override
            public void onChanged(List<ShopItem> itemList) {
                for(ShopItem item: itemList)
                {
                    Log.d("livedata", item.getTitle());
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.cart, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.cartIcon:
                startActivity(new Intent(shopping_cart.this, CartActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}