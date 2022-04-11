package com.project.androidassignment.room.advanced.two;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.androidassignment.R;
import com.project.androidassignment.databinding.GalleryLayoutBinding;

import java.util.List;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder> {
    Context context;
    public GalleryAdapter(Context context){
        this.context = context;
    }

    public int[] photos = {R.drawable.school1, R.drawable.school2, R.drawable.school3, R.drawable.school4};
    @NonNull
    @Override
    public GalleryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        GalleryLayoutBinding binding = GalleryLayoutBinding.inflate(inflater);
        return new GalleryViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull GalleryViewHolder holder, int position) {
        holder.binding.imageView.setImageResource(photos[position]);
    }

    @Override
    public int getItemCount() {
        return photos.length;
    }

    public class GalleryViewHolder extends RecyclerView.ViewHolder {
        public GalleryLayoutBinding binding;
        public GalleryViewHolder(@NonNull GalleryLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
