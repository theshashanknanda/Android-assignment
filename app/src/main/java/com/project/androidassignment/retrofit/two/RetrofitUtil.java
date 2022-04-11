package com.project.androidassignment.retrofit.two;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RetrofitUtil {
    @GET("?flag=SELECT")
    Call<List<Model>> getData();

    @POST("?flag=INSERT")
    @FormUrlEncoded
    Call<List<Model>> setData(@Field("id") int id,@Field("firstname") String firstname,@Field("lastname") String lastname);
}
