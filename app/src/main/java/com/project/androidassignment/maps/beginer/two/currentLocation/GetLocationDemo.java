package com.project.androidassignment.maps.beginer.two.currentLocation;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.project.androidassignment.R;
import com.project.androidassignment.databinding.ActivityGetLocationDemoBinding;

public class GetLocationDemo extends AppCompatActivity {
    private ActivityGetLocationDemoBinding binding;
    private SupportMapFragment mapFragment;
    private FusedLocationProviderClient client;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGetLocationDemoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.gMapFragment);
        client = LocationServices.getFusedLocationProviderClient(this);

        showLocation();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void checkForPermission() {
            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.R) {
                ActivityResultLauncher<String> launcher = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new ActivityResultCallback<Boolean>() {
                    @Override
                    public void onActivityResult(Boolean result) {
                        if (result) {
                            // access granted
                            showLocation();
                        } else {
                            // access not granted
                            Toast.makeText(GetLocationDemo.this, "Permission not granted", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                launcher.launch(Manifest.permission.ACCESS_FINE_LOCATION);
                launcher.launch(Manifest.permission.ACCESS_COARSE_LOCATION);
            } else {
                requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
            }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
            // permission granted
            showLocation();
        } else {
            // permission not granted
            Toast.makeText(GetLocationDemo.this, "Permission not granted", Toast.LENGTH_SHORT).show();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void showLocation() {

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            checkForPermission();
            return;
        }
        Task<Location> task = client.getLastLocation()
                .addOnSuccessListener(new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        if(location != null){
                            mapFragment.getMapAsync(new OnMapReadyCallback() {
                                @Override
                                public void onMapReady(@NonNull GoogleMap googleMap) {
                                    LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
                                    MarkerOptions options = new MarkerOptions().position(latLng).title("You are here");

                                    googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 16));
                                    googleMap.addMarker(options);
                                }
                            });
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });
    }
}
