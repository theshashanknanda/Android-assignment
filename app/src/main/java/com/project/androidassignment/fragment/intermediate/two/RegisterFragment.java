//package com.project.androidassignment.fragment.intermediate.two;
//
//import android.os.Bundle;
//
//import androidx.fragment.app.Fragment;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import com.project.androidassignment.R;
//import com.project.androidassignment.databinding.FragmentRegisterBinding;
//
//public class RegisterFragment extends Fragment {
//    private FragmentRegisterBinding binding;
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        binding = FragmentRegisterBinding.inflate(getLayoutInflater());
//        // Inflate the layout for this fragment
//        binding.login.setOnClickListener(v -> {
//            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, new LoginFragment())
//                    .addToBackStack("login").commit();
//        });
//
//        return binding.getRoot();
//    }
//}