package com.example.dailyplanner.Activity.Interface;

import com.example.dailyplanner.Activity.Model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserAPI {

@POST("/user/signup")
    Call<Void>signup(@Body User user);

@POST("user/login")
    Call<Void>login(@Body User user);
}
