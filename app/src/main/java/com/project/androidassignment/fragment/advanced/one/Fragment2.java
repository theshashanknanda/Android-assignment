package com.project.androidassignment.fragment.advanced.one;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.androidassignment.R;
import com.project.androidassignment.databinding.Fragment2Binding;

public class Fragment2 extends Fragment {
    private Fragment2Binding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = Fragment2Binding.inflate(inflater);
        // Inflate the layout for this fragment

        Person data;
        Bundle bundle = this.getArguments();
        if(bundle != null){
            data = (Person) bundle.getSerializable("key");

            binding.tv.setText(data.toString());
        }

        return binding.getRoot();
    }
}