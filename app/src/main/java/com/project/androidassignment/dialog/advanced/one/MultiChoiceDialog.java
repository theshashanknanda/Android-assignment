package com.project.androidassignment.dialog.advanced.one;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.project.androidassignment.databinding.ActivityMultiChoiceDialogBinding;

import java.util.ArrayList;

public class MultiChoiceDialog extends AppCompatActivity {
    private ActivityMultiChoiceDialogBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMultiChoiceDialogBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.button5.setOnClickListener(v -> {
            String cities[] = {"Ahmedabad", "Surat", "Baroda", "Rajkot"};
            ArrayList<String> list = new ArrayList<>();
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Select cities");
            builder.setMultiChoiceItems(cities, new boolean[]{false, false, false, false}, new DialogInterface.OnMultiChoiceClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                    if(isChecked){
                        list.add(cities[which]);
                    }else{
                        list.remove(which);
                    }
                    binding.textView11.setText(list.toString());
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        });
    }
}