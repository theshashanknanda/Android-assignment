package com.project.androidassignment.room.advanced.two;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.androidassignment.databinding.InformationLayoutBinding;

import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder> {
    public Context context;
    public List<String> stringList;
    public CourseAdapter(Context context, List<String> stringList){
        this.context = context;
        this.stringList = stringList;
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        InformationLayoutBinding binding = InformationLayoutBinding.inflate(inflater);
        return new CourseViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {
        holder.binding.courseNameTV.setText(stringList.get(position));
    }

    @Override
    public int getItemCount() {
        return stringList.size();
    }

    public class CourseViewHolder extends RecyclerView.ViewHolder {
        public InformationLayoutBinding binding;
        public CourseViewHolder(InformationLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
