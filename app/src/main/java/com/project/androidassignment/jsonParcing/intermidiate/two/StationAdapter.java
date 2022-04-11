package com.project.androidassignment.jsonParcing.intermidiate.two;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;

import com.project.androidassignment.databinding.StationLayoutBinding;

import java.util.List;

public class StationAdapter extends RecyclerView.Adapter<StationAdapter.StationViewHolder> {
    private List<String> stringList;
    private Context context;

    public StationAdapter(List<String> stringList, Context context){
        this.stringList = stringList;
        this.context = context;
    }

    @NonNull
    @Override
    public StationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        StationLayoutBinding binding = StationLayoutBinding.inflate(inflater, parent, false);

        return new StationViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull StationViewHolder holder, int position) {
        holder.binding.stationTV.setText(stringList.get(position));
    }

    @Override
    public int getItemCount() {
        return stringList.size();
    }

    public class StationViewHolder extends RecyclerView.ViewHolder {
        public StationLayoutBinding binding;
        public StationViewHolder(@NonNull StationLayoutBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }
    }
}
