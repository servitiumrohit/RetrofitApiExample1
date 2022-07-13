package com.example.mvvmdesignpatternusingretrofit.api;

import com.example.mvvmdesignpatternusingretrofit.modal.ResponseModal;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiServices {
    @GET("api/users?page=2")
    public Call<ResponseModal> getAllData();
}
