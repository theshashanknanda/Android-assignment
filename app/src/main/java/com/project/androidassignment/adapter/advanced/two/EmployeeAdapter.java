package com.project.androidassignment.adapter.advanced.two;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.androidassignment.adapter.advanced.one.Employee;
import com.project.androidassignment.databinding.CardRecyclerBinding;

import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder> {
    private List<Employee> employeeList;
    private Context context;

    public EmployeeAdapter(Context context, List<Employee> employeeList){
        this.employeeList = employeeList;
        this.context = context;
    }

    @NonNull
    @Override
    public EmployeeAdapter.EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        CardRecyclerBinding binding = CardRecyclerBinding.inflate(inflater, parent, false);

        return new EmployeeViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeAdapter.EmployeeViewHolder holder, int position) {
        Employee employee = employeeList.get(position);
        holder.binding.setEmp(employee);
    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }

    public class EmployeeViewHolder extends RecyclerView.ViewHolder {
        public CardRecyclerBinding binding;
        public EmployeeViewHolder(@NonNull CardRecyclerBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
