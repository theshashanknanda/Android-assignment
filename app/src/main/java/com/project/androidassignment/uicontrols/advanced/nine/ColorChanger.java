package com.project.androidassignment.uicontrols.advanced.nine;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.project.androidassignment.databinding.ActivityColorChangerBinding;

public class ColorChanger extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener{
    private ActivityColorChangerBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityColorChangerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.seekBar.setOnSeekBarChangeListener(this);
        binding.seekBar2.setOnSeekBarChangeListener(this);
        binding.seekBar3.setOnSeekBarChangeListener(this);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        int r = binding.seekBar.getProgress();
        int g = binding.seekBar2.getProgress();
        int b = binding.seekBar3.getProgress();

        binding.layout.setBackgroundColor(Color.rgb(r, g, b));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}