package com.example.dailyplanner.Interface;

import com.example.dailyplanner.Model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserAPI {
    @POST("/users/signup")
    Call<Void> signup (@Body User user);

    @POST("users/login")
    Call<Void> login (@Body User user);
}
