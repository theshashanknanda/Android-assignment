package com.project.androidassignment.adapter.advanced.four;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.androidassignment.databinding.AddrecylerLayoutBinding;

import java.util.List;

public class AddAdapter extends RecyclerView.Adapter<AddAdapter.AddViewHolder> {
    private List<EmployeeData> list;
    private Context context;

    public AddAdapter(Context context, List<EmployeeData> list){
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public AddAdapter.AddViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        AddrecylerLayoutBinding binding = AddrecylerLayoutBinding.inflate(inflater, parent, false);

        return new AddViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull AddAdapter.AddViewHolder holder, int position) {
        EmployeeData employeeData = list.get(position);
        holder.binding.setEmp(employeeData);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class AddViewHolder extends RecyclerView.ViewHolder {
        public AddrecylerLayoutBinding binding;
        public AddViewHolder(AddrecylerLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
