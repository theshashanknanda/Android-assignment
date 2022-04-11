package com.project.androidassignment.dialog.intermediate.three;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;

import com.project.androidassignment.databinding.ActivitySingleChoiceDialogBinding;

public class SingleChoiceDialog extends AppCompatActivity {
    private ActivitySingleChoiceDialogBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySingleChoiceDialogBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String arr[] = {"Ahmedabad", "Surat", "Baroda", "Rajkot"};

        binding.button3.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setSingleChoiceItems(arr, -1, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    binding.textView10.setText(arr[which]);
                }
            });
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    binding.textView10.setText("No Items Selected");
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        });
    }
}