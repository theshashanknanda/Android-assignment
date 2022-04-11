package com.project.androidassignment.activity.intermediate.four;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import com.project.androidassignment.R;
import com.project.androidassignment.databinding.ActivityIntegerSumBinding;

public class IntegerSum extends AppCompatActivity {

    private ActivityIntegerSumBinding binding;
    public EditText editText1, editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =ActivityIntegerSumBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.button.setOnClickListener(v -> {
            editText1 = findViewById(R.id.num1_id);
            editText2 = findViewById(R.id.num2_id);

            int num1 = Integer.valueOf(editText1.getText().toString());
            int num2 = Integer.valueOf(editText2.getText().toString());

            int sum = num1 + num2;

            Intent i = new Intent(IntegerSum.this, ResultActivity.class);
            i.putExtra("sum", sum);
            startActivity(i);
        });
    }
}