package com.project.androidassignment.adapter.advanced.six;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.project.androidassignment.databinding.ActivityRatingRecylerViewBinding;

import java.util.ArrayList;

public class RatingRecylerView extends AppCompatActivity {
    private ActivityRatingRecylerViewBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRatingRecylerViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<RatingModel> models = new ArrayList<>();
        models.add(new RatingModel(5));
        models.add(new RatingModel(2));
        models.add(new RatingModel(4));
        models.add(new RatingModel(4.5f));
        models.add(new RatingModel(3));

        RatingAdapter adapter = new RatingAdapter(this, models);

        binding.recyclerView2.setAdapter(adapter);
        binding.recyclerView2.setLayoutManager(new LinearLayoutManager(this));
    }
}