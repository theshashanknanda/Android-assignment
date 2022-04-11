package com.project.androidassignment.fragment.basic.two;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.androidassignment.R;
import com.project.androidassignment.databinding.FragmentFirstBinding;


public class FirstFragment extends Fragment {
    private FragmentFirstBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFirstBinding.inflate(getLayoutInflater());

        binding.next.setOnClickListener(v -> {
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new SecondFragment()).commit();
        });

        return binding.getRoot();
    }
}