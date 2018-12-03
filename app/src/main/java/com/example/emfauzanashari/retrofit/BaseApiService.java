package com.example.emfauzanashari.retrofit;

import com.example.emfauzanashari.Model.Login.LoginUser;
import com.example.emfauzanashari.Model.Login.ResponseLogin;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface BaseApiService {

    @POST("auth/signin")
    Call<ResponseLogin> getLogin (@Body LoginUser loginUser);





}
