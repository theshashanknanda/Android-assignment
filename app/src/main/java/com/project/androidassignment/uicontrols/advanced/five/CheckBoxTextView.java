package com.project.androidassignment.uicontrols.advanced.five;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;

import com.project.androidassignment.databinding.ActivityCheckBoxTextViewBinding;

public class CheckBoxTextView extends AppCompatActivity {
    private ActivityCheckBoxTextViewBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCheckBoxTextViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    binding.textView6.setVisibility(View.VISIBLE);
                else
                    binding.textView6.setVisibility(View.INVISIBLE);
            }
        });
    }
}