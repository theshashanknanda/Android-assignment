package com.project.androidassignment.storage.one;

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
import com.project.androidassignment.R;
import com.project.androidassignment.databinding.ActivityAppDirectoryExternalBinding;

import java.io.File;

public class AppDirectoryExternal extends AppCompatActivity {
    private ActivityAppDirectoryExternalBinding binding;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAppDirectoryExternalBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        permissions();
    }

    private void createAppDirectory() {
        File file = new File(Environment.getExternalStorageDirectory(), "AndroidAssignment");
        if(!file.exists()){
            file.mkdir();
        }
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
                                createAppDirectory();
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
            createAppDirectory();
        }
        else{
            Snackbar.make(binding.getRoot(), "Failed", Snackbar.LENGTH_SHORT).show();
        }
    }
}