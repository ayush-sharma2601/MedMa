package com.example.radyapp;

import com.example.radyapp.Models.LoginCall;
import com.example.radyapp.Models.UserRegisterModel;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RetrofitAPIInterface {

    @FormUrlEncoded
    @POST("/register")
    Call<String> registerUser(@Body Map<String,String> user);

    @FormUrlEncoded
    @POST("/login")
    Call<LoginCall> loginUser(@Field("email") String email,@Field("password") String password);



}
