package com.project.androidassignment.dialog.intermediate.one;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.project.androidassignment.R;
import com.project.androidassignment.databinding.ActivityAlertDialogBinding;

public class AlertDialog extends AppCompatActivity {
    private ActivityAlertDialogBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAlertDialogBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(this);
        builder.setTitle("Title");
        builder.setMessage("Description");
        builder.setIcon(getResources().getDrawable(R.drawable.person));
        androidx.appcompat.app.AlertDialog dialog = builder.create();
        dialog.show();
    }
}