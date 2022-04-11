package com.project.androidassignment.menu.basic.two;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.widget.ArrayAdapter;

import com.project.androidassignment.R;
import com.project.androidassignment.databinding.ActivityListViewContextMenuBinding;

public class ListViewContextMenu extends AppCompatActivity {
    private ActivityListViewContextMenuBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListViewContextMenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,
                new String[]{"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"});
        binding.listView.setAdapter(adapter);

        registerForContextMenu(binding.listView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.context_menu_demo, menu);
    }
}