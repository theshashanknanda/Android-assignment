package com.project.androidassignment.jsonParcing.intermidiate.one;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.project.androidassignment.databinding.ActivityCricketApiBinding;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import okhttp3.OkHttp;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class CricketAPI extends AppCompatActivity {
    private ActivityCricketApiBinding binding;
    private List<String> matchList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCricketApiBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        matchList = new ArrayList<>();

        try {
            Executor executors = Executors.newSingleThreadExecutor();
            executors.execute(new Runnable() {
                @Override
                public void run() {
                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder()
                            .url("https://cricket-live-data.p.rapidapi.com/series")
                            .get()
                            .addHeader("x-rapidapi-host", "cricket-live-data.p.rapidapi.com")
                            .addHeader("x-rapidapi-key","1608267b96msh2d1b3bf94e7f4fap1548efjsnbf60559bde44")
                            .build();
                    Response response = null;
                    try {
                        response = client.newCall(request).execute();

                        JSONObject object =  new JSONObject(response.body().string());
                        JSONArray array = object.getJSONArray("results");
                        JSONObject internalObject = array.getJSONObject(0);
                        JSONArray testSeries = internalObject.getJSONArray("series");

                        for(int i = 0; i < testSeries.length(); i++)
                        {
                            JSONObject object1 = (JSONObject) testSeries.get(i);
                            String name = object1.getString("series_name");

                            matchList.add(name);
                        }

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                ArrayAdapter<String> adapter = new ArrayAdapter<>(CricketAPI.this, android.R.layout.simple_list_item_1, matchList);
                                binding.listView.setAdapter(adapter);
                            }
                        });

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}