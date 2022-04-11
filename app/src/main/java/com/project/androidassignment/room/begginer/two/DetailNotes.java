package com.project.androidassignment.room.begginer.two;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.project.androidassignment.databinding.ActivityDetailNotesBinding;
import com.project.androidassignment.room.begginer.one.NoteViewModel;

public class DetailNotes extends AppCompatActivity {
    private ActivityDetailNotesBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailNotesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int id = getIntent().getIntExtra("id", 0);
        String title = getIntent().getStringExtra("title");
        String des = getIntent().getStringExtra("des");

        NoteEntity entity = new NoteEntity(title, des);
        entity.id = id;

        NoteViewModel viewModel = new ViewModelProvider(this).get(NoteViewModel.class);

        binding.detailTitleED.setText(title);
        binding.detailDesED.setText(des);

        binding.updateButton.setOnClickListener(view -> {
            String newTitle = binding.detailTitleED.getText().toString();
            String newDes = binding.detailDesED.getText().toString();

            entity.title = newTitle;
            entity.description = newDes;

            viewModel.update(entity);
            finish();
        });

        binding.deleteButton.setOnClickListener(view -> {
            viewModel.delete(id);
            finish();
        });
    }
}