package com.project.androidassignment.fragment.intermediate.one;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.androidassignment.R;
import com.project.androidassignment.databinding.FragmentSplashBinding;
import com.project.androidassignment.fragment.basic.two.FirstFragment;

public class SplashFragment extends Fragment {
    private FragmentSplashBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSplashBinding.inflate(inflater);
        // Inflate the layout for this fragment
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.splashContainer, new FirstFragment()).commit();
            }
        }, 2000);
        return binding.getRoot();
    }
}