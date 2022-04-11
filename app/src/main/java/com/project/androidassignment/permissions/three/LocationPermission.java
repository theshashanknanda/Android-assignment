package com.project.androidassignment.permissions.three;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;
import com.project.androidassignment.databinding.ActivityLocationPermissionBinding;

public class LocationPermission extends AppCompatActivity {
    private ActivityLocationPermissionBinding binding;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLocationPermissionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        permission();
    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    private void permission() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.R){
            ActivityResultLauncher<String> launcher = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new ActivityResultCallback<Boolean>() {
                @Override
                public void onActivityResult(Boolean result) {
                    if(result){
                        Snackbar.make(binding.getRoot(), "Permission Granted", Snackbar.LENGTH_SHORT).show();
                    }
                    else{
                        Snackbar.make(binding.getRoot(), "Permission Denied", Snackbar.LENGTH_SHORT).show();
                    }
                }
            });
            launcher.launch(Manifest.permission.ACCESS_FINE_LOCATION);
            launcher.launch(Manifest.permission.ACCESS_COARSE_LOCATION);
            launcher.launch(Manifest.permission.ACCESS_BACKGROUND_LOCATION);
        }
        else{
            if(!((ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED)
                    &&
                    (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED)))
            {
                requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_BACKGROUND_LOCATION}, 101);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
            Snackbar.make(binding.getRoot(), "Permission Granted", Snackbar.LENGTH_SHORT).show();
        }
        else{
            Snackbar.make(binding.getRoot(), "Permission Denied", Snackbar.LENGTH_SHORT).show();
        }
    }
}