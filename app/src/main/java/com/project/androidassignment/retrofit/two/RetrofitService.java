package com.project.androidassignment.retrofit.two;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {
    public static RetrofitUtil service;

    public static RetrofitUtil getInstance(){
        if(service == null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://war-torn-accordance.000webhostapp.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            service = retrofit.create(RetrofitUtil.class);
        }
        return service;
    }
}
