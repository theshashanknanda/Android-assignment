package com.project.androidassignment.menu.advanced.one;

import android.os.Bundle;

import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.project.androidassignment.R;
import com.project.androidassignment.databinding.ActivityGmailDrawerBinding;
import com.project.androidassignment.databinding.FragmentAllInboxesBinding;

public class AllInboxes extends Fragment {
    private FragmentAllInboxesBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAllInboxesBinding.inflate(inflater);
        // Inflate the layout for this fragment

        return binding.getRoot();
    }
}