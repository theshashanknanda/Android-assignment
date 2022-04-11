package com.project.androidassignment.adapter.advanced.nine;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.snackbar.Snackbar;
import com.project.androidassignment.R;
import com.project.androidassignment.databinding.ActivityTodoDemoBinding;
import com.project.androidassignment.databinding.AddLayoutBinding;
import com.project.androidassignment.databinding.UpdateLayoutBinding;

import java.util.ArrayList;

public class TodoDemo extends AppCompatActivity {
    private ActivityTodoDemoBinding binding;
    private ArrayList<String> list;
    private ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTodoDemoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        list = new ArrayList<>();

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddLayoutBinding addLayoutBinding = AddLayoutBinding.inflate(getLayoutInflater());
                AlertDialog.Builder builder = new AlertDialog.Builder(TodoDemo.this);
                builder.setView(addLayoutBinding.getRoot());

                AlertDialog dialog = builder.create();
                dialog.show();

                addLayoutBinding.saveButton.setOnClickListener(view -> {
                    String text = addLayoutBinding.addED.getText().toString().trim();
                    list.add(text);

                    adapter.notifyDataSetChanged();

                    dialog.dismiss();
                });
            }
        });

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);
        binding.listView.setAdapter(adapter);

        registerForContextMenu(binding.listView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int index = info.position;

        switch (item.getItemId()){
            case R.id.editMenu:
                // Update

                UpdateLayoutBinding updateLayoutBinding = UpdateLayoutBinding.inflate(getLayoutInflater());
                AlertDialog.Builder updateBuilder = new AlertDialog.Builder(this);
                updateBuilder.setView(updateLayoutBinding.getRoot());

                AlertDialog updateDialog = updateBuilder.create();
                updateDialog.show();

                updateLayoutBinding.addED.setText(list.get(index));

                updateLayoutBinding.saveButton.setOnClickListener(v -> {
                    list.set(index, updateLayoutBinding.addED.getText().toString().trim());
                    adapter.notifyDataSetChanged();

                    updateDialog.dismiss();
                });

                break;

            case R.id.deleteMenu:
                // Delete

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Are you sure to delete this item?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        list.remove(index);

                        adapter.notifyDataSetChanged();
                    }
                });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
                break;

            case R.id.cancelMenu:
                // Cancel

                break;
        }

        return super.onContextItemSelected(item);
    }
}