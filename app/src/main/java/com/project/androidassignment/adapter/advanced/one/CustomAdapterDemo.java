package com.project.androidassignment.adapter.advanced.one;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.androidassignment.databinding.CustomLayoutBinding;

import java.util.ArrayList;

public class CustomAdapterDemo extends RecyclerView.Adapter<CustomAdapterDemo.ViewHolder> {
    public Context context;
    public ArrayList<Employee> list;

    public CustomAdapterDemo(Context context, ArrayList<Employee> list){
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        CustomLayoutBinding binding = CustomLayoutBinding.inflate(inflater,parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Employee employee = list.get(position);
        holder.binding.setData(employee);
        holder.binding.imageView.setImageResource(employee.getPhoto());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CustomLayoutBinding binding;
        public ViewHolder(CustomLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
