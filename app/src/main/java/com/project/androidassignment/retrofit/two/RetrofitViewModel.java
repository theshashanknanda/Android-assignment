package com.project.androidassignment.retrofit.two;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitViewModel extends AndroidViewModel {
    private MutableLiveData<List<Model>> liveData;;
    private RetrofitUtil util;
    public RetrofitViewModel(@NonNull Application application) {
        super(application);

        liveData = new MutableLiveData<>();
        util = RetrofitService.getInstance();
    }

    public MutableLiveData<List<Model>> getLiveData() {
        return liveData;
    }

    public void setLiveData(MutableLiveData<List<Model>> liveData) {
        this.liveData = liveData;
    }

    void getData(){
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                Call<List<Model>> call = util.getData();
                call.enqueue(new Callback<List<Model>>() {
                    @Override
                    public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
                        getLiveData().postValue(response.body());
                        Log.d("retrofitResponce", response.body().toString());
                    }

                    @Override
                    public void onFailure(Call<List<Model>> call, Throwable t) {
                        Log.d("retrofitResponce", t.getLocalizedMessage());
                    }
                });
            }
        }, 0, 1, TimeUnit.SECONDS);
    }

    void setData(int id, String firstname, String lastname){
        util.setData(id, firstname, lastname).enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {

            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {

            }
        });
    }
}
