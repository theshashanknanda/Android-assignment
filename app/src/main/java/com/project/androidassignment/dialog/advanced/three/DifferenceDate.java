package com.project.androidassignment.dialog.advanced.three;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.widget.DatePicker;

import com.project.androidassignment.databinding.ActivityDifferenceDateBinding;

public class DifferenceDate extends AppCompatActivity {
    private ActivityDifferenceDateBinding binding;
    private Calendar c1, c2;
    private long m1 = 0, m2 = 0;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDifferenceDateBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        c1 = Calendar.getInstance();
        c2 = Calendar.getInstance();

        binding.button6.setOnClickListener(v -> {
            DatePickerDialog dialog = new DatePickerDialog(this);
            dialog.setOnDateSetListener(new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    c1.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                    c1.set(Calendar.MONTH, month+1);
                    c1.set(Calendar.YEAR, year);

                    m1 = c1.getTimeInMillis();
                }
            });

            dialog.show();
        });

        binding.button7.setOnClickListener(v -> {
            DatePickerDialog dialog = new DatePickerDialog(this);
            dialog.setOnDateSetListener(new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    c2.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                    c2.set(Calendar.MONTH, month+1);
                    c2.set(Calendar.YEAR, year);

                    m2 = c2.getTimeInMillis();
                }
            });

            dialog.show();
        });

        binding.button8.setOnClickListener(v -> {
            long diff = m2 - m1;
            long days = diff / (1000*60*60*24);

            binding.textView12.setText(String.valueOf("Difference: " + days));
        });
    }
}