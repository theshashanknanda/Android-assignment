package com.project.androidassignment.uicontrols.intemediate.one;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import com.project.androidassignment.databinding.ActivityReverseNumberBinding;

public class ReverseNumber extends AppCompatActivity {
    private ActivityReverseNumberBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityReverseNumberBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.number.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String text = s.toString();
                StringBuilder builder = new StringBuilder();
                builder.append(text);
                builder.reverse();
                String rev = builder.toString();

                binding.reverse.setText(rev);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}