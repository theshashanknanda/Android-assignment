package com.project.androidassignment.maps.intermediate.trueway_geocoding;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.project.androidassignment.R;
import com.project.androidassignment.databinding.ActivityGeocodingDemoBinding;

public class GeocodingDemo extends AppCompatActivity {
    private ActivityGeocodingDemoBinding binding;
    private SupportMapFragment mapFragment;
    private GeoViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGeocodingDemoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.gMapFragmentAddress);

        viewModel = new ViewModelProvider.AndroidViewModelFactory(getApplication()).create(GeoViewModel.class);

        binding.searchBtn.setOnClickListener(v -> {
            String address = binding.addressED.getText().toString().toString();

            viewModel.loadData(address);
        });

        viewModel.getResponse().observe(this, new Observer<GeoResponse>() {
            @Override
            public void onChanged(GeoResponse geoResponse) {
                String placeName = geoResponse.getResults().get(0).getAddress();
                Double lat = geoResponse.getResults().get(0).getLocation().getLat();
                Double lng = geoResponse.getResults().get(0).getLocation().getLng();

                mapFragment.getMapAsync(new OnMapReadyCallback() {
                    @Override
                    public void onMapReady(@NonNull GoogleMap googleMap) {
                        LatLng latLng = new LatLng(lat, lng);
                        MarkerOptions markerOptions = new MarkerOptions().position(latLng).title(placeName);

                        googleMap.addMarker(markerOptions);
                        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 16));
                    }
                });
            }
        });
    }
}