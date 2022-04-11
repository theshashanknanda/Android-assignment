package com.project.androidassignment.room.advanced.one;

import android.app.Application;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.androidassignment.R;
import com.project.androidassignment.databinding.TaskLayoutBinding;
import com.project.androidassignment.menu.intermediate.one.PopupMenu;

import java.util.Date;
import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {
    private Context application;
    private List<TaskEntity> entityList;

    public TaskAdapter(Context application, List<TaskEntity> entityList){
        this.entityList = entityList;
        this.application = application;
    }

    @NonNull
    @Override
    public TaskAdapter.TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(application);
        TaskLayoutBinding binding = TaskLayoutBinding.inflate(inflater, parent, false);

        return new TaskViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskAdapter.TaskViewHolder holder, int position) {
        TaskEntity entity = entityList.get(position);
        holder.binding.title.setText(entity.name);
        holder.binding.des.setText(entity.description);
        holder.binding.priorityTextView.setText(entity.priority);

        String hex = entity.priorityColor;
        holder.binding.priorityImageView.setBackgroundColor(Color.parseColor(hex));

        // current time
        long currentMillis = System.currentTimeMillis();
        int currentMinutes = (int) ((currentMillis / 1000) / 60);


        // Earlier minutes
        long millis = entity.time;
        int minutes = (int) ((millis / 1000) / 60);


        // Ago time
        int finalMinutes = currentMinutes - minutes;

        holder.binding.date.setText("Time: " + String.valueOf(finalMinutes) + " Minutes ago");

        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(application, DetailTask.class);
            intent.putExtra("id", entity.id);
            intent.putExtra("title", entity.name);
            intent.putExtra("des", entity.description);

            application.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return entityList.size();
    }

    public class TaskViewHolder extends RecyclerView.ViewHolder {
        public TaskLayoutBinding binding;
        public TaskViewHolder(@NonNull TaskLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
