package com.project.androidassignment.storage.three;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;

import com.google.android.material.snackbar.Snackbar;
import com.project.androidassignment.databinding.ActivityExternalReadWriteBinding;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class ExternalReadWrite extends AppCompatActivity {
    private ActivityExternalReadWriteBinding binding;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityExternalReadWriteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        permissions();

        binding.saveButton.setOnClickListener(v -> {
            String text = binding.editText3.getText().toString();
            File file = new File(Environment.getExternalStorageDirectory(), "AndroidAssignment");
            if(!file.exists())
                file.mkdir();

            File innerFile = new File(file, "demo.txt");
            try {
                FileOutputStream os = new FileOutputStream(innerFile);
                os.write(text.getBytes());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        binding.readButton.setOnClickListener(v -> {
            File file = new File(Environment.getExternalStorageDirectory(), "AndroidAssignment");
            File innerFile = new File(file, "demo.txt");

            try {
                FileInputStream is = new FileInputStream(innerFile);
                byte[] arr = new byte[is.available()];
                is.read(arr);
                String text = new String(arr);

                binding.tv.setText(text);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void permissions() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.R){
            // Above API 30
            ActivityResultLauncher<Intent> launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                    new ActivityResultCallback<ActivityResult>() {
                        @Override
                        public void onActivityResult(ActivityResult result) {
                            if(Environment.isExternalStorageManager()){
                                Snackbar.make(binding.getRoot(), "Success", Snackbar.LENGTH_SHORT).show();
                            }
                            else{
                                Snackbar.make(binding.getRoot(), "Failed", Snackbar.LENGTH_SHORT).show();
                            }
                        }
                    });

            if(!Environment.isExternalStorageManager()){
                Intent intent = new Intent(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION);
                launcher.launch(intent);
            }
        }else{
            // Below API 30
            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    101);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED){
            Snackbar.make(binding.getRoot(), "Success", Snackbar.LENGTH_SHORT).show();
        }
        else{
            Snackbar.make(binding.getRoot(), "Failed", Snackbar.LENGTH_SHORT).show();
        }
    }
}