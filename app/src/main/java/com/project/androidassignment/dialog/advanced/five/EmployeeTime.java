package com.project.androidassignment.dialog.advanced.five;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.TimePicker;

import com.google.android.material.snackbar.Snackbar;
import com.project.androidassignment.databinding.ActivityEmployeeTimeBinding;

import java.util.Calendar;

public class EmployeeTime extends AppCompatActivity {
    private ActivityEmployeeTimeBinding binding;
    private Calendar c1, c2;
    private long m1=0, m2=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEmployeeTimeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        c1 = Calendar.getInstance();
        c2 = Calendar.getInstance();

        binding.button9.setOnClickListener(v -> {
            TimePickerDialog dialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    c1.set(Calendar.HOUR_OF_DAY, hourOfDay);
                    c1.set(Calendar.MINUTE, minute);
                    c1.set(Calendar.SECOND, 0);

                    m1 = c1.getTimeInMillis();
                }
            }, 0, 0, true);
            dialog.show();
        });

        binding.button11.setOnClickListener(v -> {
            TimePickerDialog dialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    c2.set(Calendar.HOUR_OF_DAY, hourOfDay);
                    c2.set(Calendar.MINUTE, minute);
                    c2.set(Calendar.SECOND, 0);

                    m2 = c2.getTimeInMillis();
                }
            }, 0, 0, true);
            dialog.show();
        });

        binding.button12.setOnClickListener(v -> {
            long diff = m2- m1;
            long minute = diff / (1000*60);
            binding.textView13.setText("Minutes: " + String.valueOf(minute));
        });
    }
}