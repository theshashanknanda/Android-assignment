package com.project.androidassignment.animation.intermidiate.five.framebyframe;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.project.androidassignment.R;
import com.project.androidassignment.databinding.ActivityFrameByFrameDemoBinding;

public class FrameByFrameDemo extends AppCompatActivity {
    private ActivityFrameByFrameDemoBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFrameByFrameDemoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BitmapDrawable frame1 = (BitmapDrawable) getResources().getDrawable(R.drawable.pb1);
        BitmapDrawable frame2 = (BitmapDrawable) getResources().getDrawable(R.drawable.pb2);
        BitmapDrawable frame3 = (BitmapDrawable) getResources().getDrawable(R.drawable.pb3);

        AnimationDrawable ad = new AnimationDrawable();
        ad.addFrame(frame1, 500);
        ad.addFrame(frame2, 500);
        ad.addFrame(frame3, 500);

        binding.imageView8.setImageDrawable(ad);

        binding.startBtn.setOnClickListener(v -> {
            ad.start();
        });

        binding.stopBtn.setOnClickListener(v -> {
            ad.stop();
        });
    }
}
