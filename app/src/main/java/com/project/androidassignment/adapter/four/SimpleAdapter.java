package com.project.androidassignment.adapter.four;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.project.androidassignment.R;
import com.project.androidassignment.databinding.ActivitySimpleAdapterBinding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SimpleAdapter extends AppCompatActivity {
    private ActivitySimpleAdapterBinding binding;
    private String name[] = {"Thomas", "Arthur", "Polly", "Copper", "Shelby"};
    private String roles[] = {"CEO", "MD", "Chief", "Officer", "Worker"};
    private android.widget.SimpleAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySimpleAdapterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<HashMap<String, Object>> list = new ArrayList<>();
        for(int i = 0; i < name.length; i++)
        {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("name", name[i]);
            hashMap.put("role", roles[i]);

            list.add(hashMap);
        }

        String from[] = {"name", "role"};
        int to[] = {R.id.employeeName, R.id.positionName};

        adapter = new android.widget.SimpleAdapter(this, list, R.layout.simple_adapter_row,
                from, to);
        binding.listView.setAdapter(adapter);
    }
}