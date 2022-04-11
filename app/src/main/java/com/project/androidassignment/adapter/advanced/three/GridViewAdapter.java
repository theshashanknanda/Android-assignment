package com.project.androidassignment.adapter.advanced.three;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.androidassignment.databinding.GridviewlayoutBinding;

import java.util.ArrayList;
import java.util.List;

public class GridViewAdapter extends RecyclerView.Adapter<GridViewAdapter.GridViewHolder> {
    private List<Integer> list;
    private Context context;

    public GridViewAdapter(Context context, List<Integer> list){
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public GridViewAdapter.GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        GridviewlayoutBinding binding = GridviewlayoutBinding.inflate(inflater, parent, false);
        return new GridViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewAdapter.GridViewHolder holder, int position) {
        holder.binding.imageView5.setImageResource(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class GridViewHolder extends RecyclerView.ViewHolder {
        public GridviewlayoutBinding binding;
        public GridViewHolder(@NonNull GridviewlayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
