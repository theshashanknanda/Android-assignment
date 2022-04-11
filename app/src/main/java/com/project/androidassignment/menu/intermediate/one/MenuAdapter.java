package com.project.androidassignment.menu.intermediate.one;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.PopupMenu;
import androidx.recyclerview.widget.RecyclerView;

import com.project.androidassignment.R;
import com.project.androidassignment.databinding.RecyclerRowBinding;

import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {

    private Context context;
    private List<String> list;
    public MenuAdapter(List<String> list, Context context){
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        RecyclerRowBinding binding = RecyclerRowBinding.inflate(inflater);
        return new MenuViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        holder.binding.setStr(list.get(position));
        holder.binding.layout.setOnClickListener(v -> {
            PopupMenu popupMenu = new PopupMenu(context, holder.binding.textView);
            popupMenu.getMenuInflater().inflate(R.menu.context_menu_demo, popupMenu.getMenu());
            popupMenu.show();
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MenuViewHolder extends RecyclerView.ViewHolder {
        public RecyclerRowBinding binding;
        public MenuViewHolder(RecyclerRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
