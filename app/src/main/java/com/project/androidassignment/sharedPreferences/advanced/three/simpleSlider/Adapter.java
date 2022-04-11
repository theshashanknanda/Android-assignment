package com.project.androidassignment.sharedPreferences.advanced.three.simpleSlider;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import com.project.androidassignment.databinding.PagerBinding;

public class Adapter extends PagerAdapter {

    public String titles[] = {"Title 1", "Title 2", "Title 3"};
    public String des = "Lorem ipsum dolor sit amet, consectetur adipiscing elit,\n" +
            "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam";

    @Override
    public int getCount() {
        return 3;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(container.getContext());
        PagerBinding binding = PagerBinding.inflate(inflater);

        binding.title.setText(titles[position]);
        binding.des.setText(des);

        if(position == 1) {
            binding.layout.setBackgroundColor(Color.WHITE);
            binding.title.setTextColor(Color.BLACK);
            binding.des.setTextColor(Color.BLACK);
        }
        else{
            binding.layout.setBackgroundColor(Color.parseColor("#4361ee"));
            binding.title.setTextColor(Color.WHITE);
            binding.des.setTextColor(Color.WHITE);
        }

        container.addView(binding.getRoot());

        return binding.getRoot();
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout)object);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {

        return view == object;
    }
}
