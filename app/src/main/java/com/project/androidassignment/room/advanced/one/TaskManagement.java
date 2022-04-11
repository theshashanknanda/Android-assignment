package com.project.androidassignment.room.advanced.one;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.google.android.material.snackbar.Snackbar;
import com.project.androidassignment.databinding.ActivityTaskManagmentBinding;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskManagement extends AppCompatActivity {
    private ActivityTaskManagmentBinding binding;
    private TaskViewModel viewModel;
    private List<TaskEntity> entityList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTaskManagmentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        entityList = new ArrayList<>();
        TaskAdapter adapter2 = new TaskAdapter(this, entityList);
        binding.recylerView.setAdapter(adapter2);
        binding.recylerView.setLayoutManager(new LinearLayoutManager(this));

        viewModel = new ViewModelProvider(this).get(TaskViewModel.class);

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("High");
        arrayList.add("Medium");
        arrayList.add("Low");

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spinner.setAdapter(adapter);

        binding.extendedFloatingActionButton2.setOnClickListener(v -> {
            String title = binding.titleED.getText().toString();
            String description = binding.descriptionED.getText().toString();
            String priority = binding.spinner.getSelectedItem().toString();
            long time = System.currentTimeMillis();
            String priorityColor;
            if(priority.equals("High")){
                priorityColor = "#ff0000";
            }else if(priority.equals("Medium")){
                priorityColor = "#0000FF";
            }else{
                priorityColor = "#00ff00";
            }

            TaskEntity entity = new TaskEntity();
            entity.name = title;
            entity.description = description;
            entity.time = time;
            entity.priority = priority;
            entity.priorityColor = priorityColor;

            viewModel.insert(entity);
        });

        viewModel.entities.observe(this, new Observer<List<TaskEntity>>() {
            @Override
            public void onChanged(List<TaskEntity> taskEntities) {
                entityList.clear();
                for(TaskEntity entity: taskEntities)
                {
                    entityList.add(entity);
                    Log.d("task", entity.toString());
                }
                adapter2.notifyDataSetChanged();
            }
        });
    }
}
