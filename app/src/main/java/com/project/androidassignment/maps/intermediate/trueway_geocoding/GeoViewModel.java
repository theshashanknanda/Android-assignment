package com.project.androidassignment.maps.intermediate.trueway_geocoding;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GeoViewModel extends AndroidViewModel {
    private GeoService service;
    private MutableLiveData<GeoResponse> response;

    public GeoViewModel(@NonNull Application application) {
        super(application);

        service = GeoUtils.getInstance();
        response = new MutableLiveData<>();
    }

    public GeoService getService() {
        return service;
    }

    public void setService(GeoService service) {
        this.service = service;
    }

    public MutableLiveData<GeoResponse> getResponse() {
        return response;
    }

    public void setResponse(MutableLiveData<GeoResponse> response) {
        this.response = response;
    }

    public void loadData(String address){
        Call<GeoResponse> call = service.getResponse(address);
        call.enqueue(new Callback<GeoResponse>() {
            @Override
            public void onResponse(Call<GeoResponse> call, Response<GeoResponse> response) {
                getResponse().setValue(response.body());
            }

            @Override
            public void onFailure(Call<GeoResponse> call, Throwable t) {
                Log.d("geo_error", t.getLocalizedMessage());
            }
        });
    }
}
