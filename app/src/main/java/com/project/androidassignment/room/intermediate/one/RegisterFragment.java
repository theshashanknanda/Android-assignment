package com.project.androidassignment.room.intermediate.one;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.util.Printer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.snackbar.Snackbar;
import com.project.androidassignment.R;
import com.project.androidassignment.databinding.FragmentRegisterFragmnetBinding;
import com.project.androidassignment.room.advanced.two.SchoolHomeScreen;

import javax.net.ssl.SNIHostName;

public class RegisterFragment extends Fragment {
    private FragmentRegisterFragmnetBinding binding;
    private UserViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRegisterFragmnetBinding.inflate(getLayoutInflater());
        // Inflate the layout for this fragment
        viewModel = new ViewModelProvider(requireActivity()).get(UserViewModel.class);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SharedPreferences preferences = getActivity().getSharedPreferences("login", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        boolean state = preferences.getBoolean("state", false);
        if(state){
            startActivity(new Intent(getContext(), SchoolHomeScreen.class));
        }

        binding.registerButton.setOnClickListener(v -> {
            try {
                String email = binding.emailED.getText().toString();
                String password = binding.passwordED.getText().toString();

                viewModel.insert(new UserEntity(email, password));

                Snackbar.make(binding.getRoot(), "Registration successful", Snackbar.LENGTH_SHORT).show();
                binding.emailED.setText("");
                binding.passwordED.setText("");

                editor.putBoolean("state", true);
                editor.apply();

                startActivity(new Intent(getContext(), SchoolHomeScreen.class));
            }catch (Exception e){
                Snackbar.make(binding.getRoot(), e.getLocalizedMessage(), Snackbar.LENGTH_LONG).show();
            }
        });

        binding.loginButton.setOnClickListener(v -> {
            Log.d("login", "here");
            String email = binding.emailED.getText().toString();
            String password = binding.passwordED.getText().toString();

            UserEntity entity = viewModel.login(email);
            if(entity != null){
                Log.d("login", entity.toString());
                if(password.equals(entity.password)){
                    Snackbar.make(binding.getRoot(), "Login successful", Snackbar.LENGTH_SHORT).show();

                    editor.putBoolean("state", true);
                    editor.apply();

                    startActivity(new Intent(getContext(), SchoolHomeScreen.class));
                }
                else{
                    Snackbar.make(binding.getRoot(), "Wrong password", Snackbar.LENGTH_SHORT).show();
                }
            }
            else{
                Snackbar.make(binding.getRoot(), "No Email found", Snackbar.LENGTH_SHORT).show();
            }
        });
    }
}