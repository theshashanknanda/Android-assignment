package com.project.androidassignment.uicontrols.intemediate.eight;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.project.androidassignment.R;
import com.project.androidassignment.databinding.ActivityTableLayoutTextViewBinding;

public class TableLayoutTextView extends AppCompatActivity {
    private ActivityTableLayoutTextViewBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTableLayoutTextViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        TableRow row = new TableRow(this);
        TextView tv = new TextView(this);
        tv.setText("TextView");
        tv.setTextSize(30);
        tv.setTextColor(Color.BLACK);
        tv.setBackgroundColor(Color.MAGENTA);

        row.addView(tv);
        row.setGravity(View.TEXT_ALIGNMENT_CENTER);

        TableLayout layout = findViewById(R.id.tableLayout);
        layout.addView(row);
    }
}