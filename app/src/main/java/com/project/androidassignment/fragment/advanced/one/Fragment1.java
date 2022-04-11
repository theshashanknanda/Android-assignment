package com.project.androidassignment.fragment.advanced.one;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.androidassignment.R;
import com.project.androidassignment.databinding.Fragment1Binding;

public class Fragment1 extends Fragment {
    private Fragment1Binding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = Fragment1Binding.inflate(inflater);

        binding.sendData.setOnClickListener(v -> {
            String text = binding.dataED.getText().toString().trim();

            Person person = new Person(text);

            Bundle bundle = new Bundle();
            bundle.putSerializable("key", person);

            Fragment2 fragment2 = new Fragment2();
            fragment2.setArguments(bundle);

            getActivity().getSupportFragmentManager().beginTransaction().addToBackStack("fragment1")
                    .replace(R.id.fView, fragment2).commit();
        });

        // Inflate the layout for this fragment
        return binding.getRoot();
    }
}