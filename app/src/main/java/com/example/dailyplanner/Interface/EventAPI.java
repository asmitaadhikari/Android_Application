package com.example.dailyplanner.Interface;


import com.example.dailyplanner.Model.event;
import com.example.dailyplanner.URL.url;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface EventAPI
{

    @POST("rem/addevent")

//    Call<Void>addevents( String token, @Field("name") event Event);

    Call<Void>addevents(@Header("Authorization")String token,@Body event Event);

//    Call<Void>addevents(@Body event Event);

}