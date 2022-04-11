package com.project.androidassignment.room.begginer.two;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import android.content.Context;

import com.project.androidassignment.databinding.NoteLayoutBinding;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder> {

    private Context context;
    private List<NoteEntity> notesList;

    public NoteAdapter(Context context, List<NoteEntity> entities){
        this.context = context;
        notesList = entities;
    }

    @NonNull
    @Override
    public NoteAdapter.NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        NoteLayoutBinding binding = NoteLayoutBinding.inflate(inflater, parent, false);

        return new NoteViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteAdapter.NoteViewHolder holder, int position) {
        holder.binding.title.setText(notesList.get(position).title);
        holder.binding.description.setText(notesList.get(position).description);

        holder.itemView.setOnClickListener(view -> {
            NoteEntity entity = new NoteEntity();
            entity = notesList.get(position);

            int id = entity.id;
            String title = entity.title;
            String description = entity.description;

            Intent intent = new Intent(context, DetailNotes.class);
            intent.putExtra("id", id);
            intent.putExtra("title", title);
            intent.putExtra("des", description);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return notesList.size();
    }

    public class NoteViewHolder extends RecyclerView.ViewHolder {
        public NoteLayoutBinding binding;
        public NoteViewHolder(@NonNull NoteLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
