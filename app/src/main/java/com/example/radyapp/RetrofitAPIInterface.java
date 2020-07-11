package com.example.radyapp;

import com.example.radyapp.Models.UserRegisterModel;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RetrofitAPIInterface {

    @POST("/register")
    Call<String> registerUser(@Body Map<String,String> user);

    @POST("/login")
    Call<String> loginUser(@Body Map<String,String> user);



}
