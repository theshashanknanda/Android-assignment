package com.project.androidassignment.uicontrols.advanced.seven;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.project.androidassignment.R;
import com.project.androidassignment.databinding.ActivityResourceListViewBinding;

public class ResourceListView extends AppCompatActivity {
    private ActivityResourceListViewBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityResourceListViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String arr[] = getResources().getStringArray(R.array.array);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arr);
        binding.listview.setAdapter(adapter);
    }
}