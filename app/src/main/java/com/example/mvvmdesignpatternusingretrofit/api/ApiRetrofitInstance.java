package com.example.mvvmdesignpatternusingretrofit.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiRetrofitInstance {
    private static final String url = "https://reqres.in/";
    private static Retrofit retrofit;
    private static ApiRetrofitInstance retrofitInstance;

    public ApiRetrofitInstance() {
        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized ApiRetrofitInstance getRetrofitInstance() {
        if (retrofitInstance == null) {
            retrofitInstance = new ApiRetrofitInstance();
        }
        return retrofitInstance;
    }

    public ApiServices getApi() {
        return retrofit.create(ApiServices.class);
    }
}
