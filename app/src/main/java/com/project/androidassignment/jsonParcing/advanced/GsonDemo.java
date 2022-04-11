package com.project.androidassignment.jsonParcing.advanced;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.project.androidassignment.databinding.ActivityGsonDemoBinding;
import com.project.androidassignment.jsonParcing.intermidiate.two.StationAdapter;
import com.project.androidassignment.jsonParcing.intermidiate.two.TrainAPI;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class GsonDemo extends AppCompatActivity {
    private ActivityGsonDemoBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGsonDemoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String json = "{\n" +
                "            \"stationName\": \"DELHI JN\",\n" +
                "            \"stationCode\": \"DLI\"\n" +
                "        }";

        Gson gson = new Gson();
        Station station = gson.fromJson(json, Station.class);
        Log.d("gson", station.toString());
    }
}