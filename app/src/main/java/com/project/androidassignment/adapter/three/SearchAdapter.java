package com.project.androidassignment.adapter.three;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.androidassignment.databinding.SearchRowBinding;

import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder> {
    public List<String> stringList;

    public SearchAdapter(List<String> stringList){
        this.stringList = stringList;
    }

    public void search(List<String> newList){

        stringList = newList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SearchViewHolder(SearchRowBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {
        holder.binding.textView16.setText(stringList.get(position));
    }

    @Override
    public int getItemCount() {
        return stringList.size();
    }

    public class SearchViewHolder extends RecyclerView.ViewHolder {
        public SearchRowBinding binding;
        public SearchViewHolder(@NonNull SearchRowBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }
    }
}
