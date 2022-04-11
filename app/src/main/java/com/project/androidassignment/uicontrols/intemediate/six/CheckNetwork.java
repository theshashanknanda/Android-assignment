package com.project.androidassignment.uicontrols.intemediate.six;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;
import com.project.androidassignment.databinding.ActivityCheckNetworkBinding;

public class CheckNetwork extends AppCompatActivity {
    private ActivityCheckNetworkBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCheckNetworkBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if(isNetwork())
            Snackbar.make(binding.getRoot(), "Connected", Snackbar.LENGTH_SHORT).show();
        else
            Snackbar.make(binding.getRoot(), "Not Connected", Snackbar.LENGTH_SHORT).show();
    }

    private boolean isNetwork() {
        ConnectivityManager manager = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);

        return  manager.getActiveNetworkInfo() != null && manager.getActiveNetworkInfo().isConnected();
    }
}