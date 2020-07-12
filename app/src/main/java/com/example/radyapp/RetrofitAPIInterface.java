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
    Call<LoginCall> registerUser(@Field("fullName") String fullName,@Field("dateOfBirth") String dob,@Field("gender") String gender,@Field("phoneNumber") String phoneNumber,@Field("address") String address,@Field("role") String role,@Field("email") String email,@Field("password") String password);

    @FormUrlEncoded
    @POST("/login")
    Call<LoginCall> loginUser(@Field("email") String email,@Field("password") String password);



}
