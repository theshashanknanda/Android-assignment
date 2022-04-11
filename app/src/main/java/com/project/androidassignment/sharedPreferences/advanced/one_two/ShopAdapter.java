package com.project.androidassignment.sharedPreferences.advanced.one_two;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import android.content.Context;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;

import com.project.androidassignment.databinding.ShopRowBinding;

import java.util.ArrayList;
import java.util.List;

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.ShopViewHolder> {

    private List<ShopItem> itemList;
    private List<ShopItem> cartList = new ArrayList<>();
    private Context context;

    public ShopAdapter(List<ShopItem> itemList, Context context){
        this.itemList = itemList;
        this.context = context;
    }

    @NonNull
    @Override
    public ShopAdapter.ShopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        ShopRowBinding binding = ShopRowBinding.inflate(inflater, parent, false);

        return new ShopViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ShopAdapter.ShopViewHolder holder, int position) {
        ShopItem item = itemList.get(position);
        holder.binding.setItem(item);

        holder.binding.addButton.setOnClickListener(v -> {
            ShopViewModel viewModel = new ViewModelProvider((ViewModelStoreOwner) context).get(ShopViewModel.class);
            viewModel.add(item);
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ShopViewHolder extends RecyclerView.ViewHolder {
        private ShopRowBinding binding;
        public ShopViewHolder(@NonNull ShopRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
