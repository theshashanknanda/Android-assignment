package com.project.androidassignment.room.advanced.one;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.project.androidassignment.databinding.ActivityDetailTaskBinding;
import com.project.androidassignment.room.begginer.one.NoteViewModel;
import com.project.androidassignment.room.begginer.two.NoteEntity;

import java.util.ArrayList;

public class DetailTask extends AppCompatActivity {
        String priority;
        String priorityColor;
    private ActivityDetailTaskBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailTaskBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int id = getIntent().getIntExtra("id", 0);
        String title = getIntent().getStringExtra("title");
        String des = getIntent().getStringExtra("des");

        TaskEntity entity = new TaskEntity();
        entity.name = title;
        entity.description = des;
        entity.id = id;

        TaskViewModel viewModel = new ViewModelProvider(this).get(TaskViewModel.class);

        binding.detailTitleED.setText(title);
        binding.detailDesED.setText(des);

        ArrayList<String> spinnerList = new ArrayList<>();
        spinnerList.add("High");
        spinnerList.add("Medium");
        spinnerList.add("Low");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, spinnerList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spinner.setAdapter(adapter);

        binding.updateButton.setOnClickListener(view -> {
            priority = binding.spinner.getSelectedItem().toString();

            if(priority.equals("High")){
                priorityColor = "#ff0000";
            }else if(priority.equals("Medium")){
                priorityColor = "#0000FF";
            }else{
                priorityColor = "#00ff00";
            }

            String newTitle = binding.detailTitleED.getText().toString();
            String newDes = binding.detailDesED.getText().toString();

            entity.id = id;
            entity.name = newTitle;
            entity.description = newDes;
            entity.priority = priority;
            entity.priorityColor = priorityColor;

            viewModel.update(entity);
            finish();
        });

        binding.deleteButton.setOnClickListener(view -> {
            viewModel.complete(id);
            finish();
        });
    }
}