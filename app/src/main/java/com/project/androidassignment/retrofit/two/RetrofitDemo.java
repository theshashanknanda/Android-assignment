package com.project.androidassignment.retrofit.two;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.project.androidassignment.databinding.ActivityRetrofitDemoBinding;
import com.project.androidassignment.databinding.PopupBinding;

import java.util.ArrayList;
import java.util.List;

public class RetrofitDemo extends AppCompatActivity {
    private ActivityRetrofitDemoBinding binding;
    private RetrofitViewModel viewModel;
    private List<Model> modelList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRetrofitDemoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        modelList = new ArrayList<>();
        ArrayAdapter adapter = new ArrayAdapter(RetrofitDemo.this, android.R.layout.simple_list_item_1,modelList);
        binding.listView.setAdapter(adapter);
        PopupBinding popupBinding = PopupBinding.inflate(getLayoutInflater());
        viewModel = new ViewModelProvider.AndroidViewModelFactory(getApplication()).create(RetrofitViewModel.class);
        viewModel.getData();
        viewModel.getLiveData().observe(this, new Observer<List<Model>>() {
            @Override
            public void onChanged(List<Model> models) {
                modelList.clear();
                for(Model model: models){
                    modelList.add(model);
                }
                adapter.notifyDataSetChanged();
            }
        });

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(popupBinding.getRoot());

        AlertDialog dialog = builder.create();

        binding.extendedFloatingActionButton3.setOnClickListener(v ->{
            dialog.show();

            popupBinding.sendDataButton.setOnClickListener(view -> {
                int id = Integer.parseInt(popupBinding.idED.getText().toString());
                String firstname = popupBinding.firstnameED.getText().toString();
                String lastname = popupBinding.lastNameED.getText().toString();

                viewModel.setData(id, firstname, lastname);
                Snackbar.make(binding.getRoot(), "Data Sent Succesfully", Snackbar.LENGTH_LONG).show();

                dialog.dismiss();
            });
        });
    }
}