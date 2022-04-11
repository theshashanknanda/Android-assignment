package com.project.androidassignment.uicontrols.intemediate.three;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.project.androidassignment.databinding.ActivityRadioButtonCalculatorBinding;

public class RadioButtonCalculator extends AppCompatActivity {
    private ActivityRadioButtonCalculatorBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRadioButtonCalculatorBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.resultButton.setOnClickListener(v -> {
            String text1 = binding.editTextN1.getText().toString();
            String text2 = binding.editTextN2.getText().toString();

            if(!text1.isEmpty() & !text2.isEmpty()){
                double num1 = Double.parseDouble(text1);
                double num2 = Double.parseDouble(text2);
                double res = 1;
                if(binding.add.isChecked())
                    res = num1 + num2;
                if(binding.sub.isChecked())
                    res = num1 - num2;
                if(binding.mul.isChecked())
                    res = num1 * num2;
                if(binding.div.isChecked())
                    res = num1 / num2;

                binding.resultTV.setText("Result: " + String.valueOf(res));
            }
        });
    }
}