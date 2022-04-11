package com.project.androidassignment.maps.intermediate.trueway_geocoding;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface GeoService {
    @GET("Geocode")
    @Headers({"X-RapidAPI-Host: trueway-geocoding.p.rapidapi.com",
            "X-RapidAPI-Key: 1608267b96msh2d1b3bf94e7f4fap1548efjsnbf60559bde44"})
    Call<GeoResponse> getResponse(@Query("address") String address);
}
