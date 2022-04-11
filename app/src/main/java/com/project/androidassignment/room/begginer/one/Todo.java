package com.project.androidassignment.room.begginer.one;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.PopupMenu;

import com.project.androidassignment.R;
import com.project.androidassignment.databinding.ActivityTodoBinding;
import com.project.androidassignment.databinding.TodoPopupBinding;

import java.util.ArrayList;
import java.util.List;

public class Todo extends AppCompatActivity {
    private ActivityTodoBinding binding;
    public List<TodoEntity> itemsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding  = ActivityTodoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        itemsList = new ArrayList<>();
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, itemsList);
        binding.listView.setAdapter(adapter);

        TodoViewModel viewModel = new ViewModelProvider(this).get(TodoViewModel.class);

        TodoPopupBinding popupBinding = TodoPopupBinding.inflate(getLayoutInflater());
        binding.floatingActionButton.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setView(popupBinding.getRoot());
            AlertDialog dialog = builder.create();
            dialog.show();

            popupBinding.appCompatButton6.setOnClickListener(view -> {
                String text = popupBinding.editText4.getText().toString();

                viewModel.insert(new TodoEntity(text));
                dialog.dismiss();
            });
        });

        viewModel.items.observe(this, new Observer<List<TodoEntity>>() {
            @Override
            public void onChanged(List<TodoEntity> todoEntities) {
                itemsList.clear();

                for(TodoEntity entity: todoEntities)
                {
                    itemsList.add(entity);
                }

                adapter.notifyDataSetChanged();
            }
        });

        TodoPopupBinding updateBinding = TodoPopupBinding.inflate(getLayoutInflater());

        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Todo.this);
                builder.setPositiveButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        AlertDialog.Builder updateBuilder = new AlertDialog.Builder(Todo.this);
                        updateBuilder.setView(updateBinding.getRoot());

                        AlertDialog dialog = updateBuilder.create();
                        dialog.show();

                        updateBinding.appCompatButton6.setOnClickListener(view1 -> {
                            String updatedText = updateBinding.editText4.getText().toString();

                            TodoEntity entity = new TodoEntity();
                            entity = itemsList.get(pos);
                            entity.task = updatedText;

                            viewModel.update(entity);

                            dialog.dismiss();
                        });
                    }
                });
                builder.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        TodoEntity entity = new TodoEntity();
                        entity = itemsList.get(pos);

                        viewModel.delete(entity.id);
                    }
                });
                builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.setTitle("Select Operation");
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }
}
