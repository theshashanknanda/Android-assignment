package com.project.androidassignment.uicontrols.intemediate.nine;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.project.androidassignment.databinding.ActivityPdfdemoBinding;

public class PDFDemo extends AppCompatActivity {
    private ActivityPdfdemoBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPdfdemoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ActivityResultLauncher<String> launcher = registerForActivityResult(new ActivityResultContracts.GetContent(), new ActivityResultCallback<Uri>() {
            @Override
            public void onActivityResult(Uri result) {
                Intent intent =  new Intent(Intent.ACTION_VIEW);
                intent.setData(result);
                startActivity(intent);
            }
        });

        binding.appCompatButton.setOnClickListener(v -> {
            launcher.launch("application/pdf");
        });
    }
}