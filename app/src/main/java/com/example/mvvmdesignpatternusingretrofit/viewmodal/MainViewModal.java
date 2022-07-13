package com.example.mvvmdesignpatternusingretrofit.viewmodal;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvmdesignpatternusingretrofit.api.ApiRetrofitInstance;
import com.example.mvvmdesignpatternusingretrofit.modal.ResponseModal;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModal extends ViewModel {
    private MutableLiveData<ResponseModal> liveData= new MutableLiveData<>();

    public MutableLiveData<ResponseModal> getLiveData(){
        return liveData;
    }

    public void makeApiCall(){
        Call<ResponseModal> call= ApiRetrofitInstance.getRetrofitInstance().getApi().getAllData();

        call.enqueue(new Callback<ResponseModal>() {
            @Override
            public void onResponse(Call<ResponseModal> call, Response<ResponseModal> response) {
                liveData.postValue(response.body());
            }

            @Override
            public void onFailure(Call<ResponseModal> call, Throwable t) {

            }
        });
    }
}
