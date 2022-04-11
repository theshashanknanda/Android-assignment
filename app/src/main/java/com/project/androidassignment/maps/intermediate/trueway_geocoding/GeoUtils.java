package com.project.androidassignment.maps.intermediate.trueway_geocoding;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GeoUtils {
    private static String BASE_URL = "https://trueway-geocoding.p.rapidapi.com/";
    private static GeoService service;

    public static GeoService getInstance(){
        if(service == null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            service = retrofit.create(GeoService.class);
        }
        return service;
    }
}
