package com.project.androidassignment.adapter.two;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.project.androidassignment.databinding.ActivityListViewBinding;

import java.util.ArrayList;

public class ListView extends AppCompatActivity {
    private ActivityListViewBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<String> list = new ArrayList<>();
        list.add("Ahmedabad");
        list.add("Surat");
        list.add("Baroda");
        list.add("Rajkot");
        list.add("Porbandar");

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);

        binding.listView.setAdapter(adapter);

        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                binding.textView9.setText(list.get(position));
            }
        });
    }
}