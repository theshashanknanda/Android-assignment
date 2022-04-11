package com.project.androidassignment.adapter.advanced.four;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.project.androidassignment.databinding.ActivityAddRecylerViewBinding;

import java.util.ArrayList;

public class AddRecylerView extends AppCompatActivity {
    private ActivityAddRecylerViewBinding binding;
    public ArrayList<EmployeeData> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddRecylerViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        list = new ArrayList<>();

        AddAdapter adapter = new AddAdapter(this, list);
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));

        binding.addButton.setOnClickListener(v -> {
            String firstName = binding.firstNameED.getText().toString().trim();
            String lastName = binding.lastNameED.getText().toString().trim();
            String email = binding.emailED.getText().toString().trim();
            String phoneNumber = binding.mobileNumberEDs.getText().toString().trim();

            EmployeeData data = new EmployeeData(firstName, lastName, email, phoneNumber);
            list.add(data);

            adapter.notifyDataSetChanged();

            binding.firstNameED.setText("");
            binding.lastNameED.setText("");
            binding.emailED.setText("");
            binding.mobileNumberEDs.setText("");
        });
    }
}