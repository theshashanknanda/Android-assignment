package com.project.androidassignment.adapter.advanced.six;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.androidassignment.R;
import com.project.androidassignment.databinding.RatingLayoutBinding;

import java.util.List;

public class RatingAdapter extends RecyclerView.Adapter<RatingAdapter.RatingViewHolder> {

    private Context context;
    private List<RatingModel> list;

    public RatingAdapter(Context context, List<RatingModel> list){
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RatingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        RatingLayoutBinding binding = RatingLayoutBinding.inflate(inflater, parent, false);

        return new RatingViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RatingViewHolder holder, int position) {
        holder.binding.ratinBar.setRating(list.get(position).getRatingValue());
        holder.itemView.setOnClickListener(v -> {
            Toast.makeText(context, String.valueOf(list.get(position).getRatingValue()), Toast.LENGTH_LONG).show();
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class RatingViewHolder extends RecyclerView.ViewHolder {
        public RatingLayoutBinding binding;
        public RatingViewHolder(@NonNull RatingLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
