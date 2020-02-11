package com.example.dailyplanner.Interface;


import com.example.dailyplanner.Model.event;
import com.example.dailyplanner.URL.url;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface EventAPI
{

    @POST("rem/addevent")
    Call<Void>addevents(@Header("Authorization")String token,@Body event Event);


    @GET("rem/")
    Call<List<event>> getevent (@Header("Authorization")String token);




}