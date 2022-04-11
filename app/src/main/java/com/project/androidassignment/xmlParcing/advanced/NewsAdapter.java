package com.project.androidassignment.xmlParcing.advanced;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;

import com.project.androidassignment.databinding.NewsFeedBinding;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {
    private List<News> newsList;
    private Context context;
    public NewsAdapter(List<News> newsList, Context context){
        this.newsList = newsList;
        this.context = context;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        NewsFeedBinding binding = NewsFeedBinding.inflate(inflater);

        return new NewsViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        holder.binding.titleTV.setText(newsList.get(position).getTitle());
        holder.binding.desTV.setText(newsList.get(position).getDes());
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder {
        public NewsFeedBinding binding;
        public NewsViewHolder(NewsFeedBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
