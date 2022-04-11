package com.project.androidassignment.dialog.intermediate.five;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.project.androidassignment.databinding.ActivityDateDialougeBinding;

public class DateDialouge extends AppCompatActivity {
    private ActivityDateDialougeBinding binding;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDateDialougeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.button4.setOnClickListener(v -> {
            DatePickerDialog dialog = new DatePickerDialog(this);
            dialog.setOnDateSetListener(new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    Snackbar.make(binding.getRoot(), String.valueOf(year) + "/" +String.valueOf(month+1) + "/"
                            + String.valueOf(dayOfMonth), Snackbar.LENGTH_SHORT).show();
                }
            });
            dialog.getDatePicker().setMinDate(System.currentTimeMillis());
            dialog.show();
        });
    }
}