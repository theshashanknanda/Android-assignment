package com.project.androidassignment.jsonParcing.intermidiate.two;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.project.androidassignment.databinding.ActivityTrainApiBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class TrainAPI extends AppCompatActivity {
    private ActivityTrainApiBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTrainApiBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                OkHttpClient client = new OkHttpClient();

                Request request = new Request.Builder()
                        .url("https://indianrailways.p.rapidapi.com/findstations.php?station=delhi")
                        .addHeader("x-rapidapi-host", "indianrailways.p.rapidapi.com")
                        .addHeader("x-rapidapi-key", "1608267b96msh2d1b3bf94e7f4fap1548efjsnbf60559bde44")
                        .build();

                try {
                    client.newCall(request).enqueue(new Callback() {
                        @Override
                        public void onFailure(@NonNull Call call, @NonNull IOException e) {

                        }

                        @Override
                        public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                            binding.progressBar.setVisibility(View.INVISIBLE);

                            String stringResponse = response.body().string();
                            try {
                                JSONObject object = new JSONObject(stringResponse);
                                JSONArray array = object.getJSONArray("stations");

                                List<String> stationList = new ArrayList<>();
                                for(int i = 0; i < array.length(); i++)
                                {
                                    JSONObject object1 = array.getJSONObject(i);
                                    String station = object1.getString("stationName");
                                    stationList.add(station);
                                }

                                Log.d("response", stationList.toString());

                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        StationAdapter adapter = new StationAdapter(stationList, TrainAPI.this);
                                        binding.recyclerView.setAdapter(adapter);
                                        binding.recyclerView.setLayoutManager(new LinearLayoutManager(TrainAPI.this));
                                    }
                                });
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}