package com.project.androidassignment.room.begginer.two;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;
import android.util.Log;

import com.project.androidassignment.R;
import com.project.androidassignment.databinding.ActivityNotesAppBinding;
import com.project.androidassignment.databinding.AddNoteLayoutBinding;
import com.project.androidassignment.room.begginer.one.NoteViewModel;

import java.util.ArrayList;
import java.util.List;

public class NotesApp extends AppCompatActivity {
    private ActivityNotesAppBinding binding;
    private List<NoteEntity> entities;
    private NoteAdapter adapter;
    private NoteViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNotesAppBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(NoteViewModel.class);

        entities = new ArrayList<>();

        adapter = new NoteAdapter(this, entities);
        binding.recylerView.setLayoutManager(new GridLayoutManager(this, 2));
        binding.recylerView.setAdapter(adapter);

        AddNoteLayoutBinding addBinding = AddNoteLayoutBinding.inflate(getLayoutInflater());

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(addBinding.getRoot());
        AlertDialog dialog = builder.create();

        binding.extendedFloatingActionButton.setOnClickListener(v -> {
            dialog.show();
            addBinding.titleED.setText("");
            addBinding.descriptionED.setText("");

            addBinding.addNoteButton.setOnClickListener(view -> {
                String title = addBinding.titleED.getText().toString();
                String description = addBinding.descriptionED.getText().toString();

                NoteEntity entity = new NoteEntity(title, description);

                viewModel.insert(entity);

                adapter.notifyDataSetChanged();
                dialog.dismiss();
            });
        });

        viewModel.entities.observe(this, new Observer<List<NoteEntity>>() {
            @Override
            public void onChanged(List<NoteEntity> liveEntities) {
                entities.clear();
                for(NoteEntity entity: liveEntities)
                {
                    entities.add(entity);
                }
                adapter.notifyDataSetChanged();
            }
        });
    }
}