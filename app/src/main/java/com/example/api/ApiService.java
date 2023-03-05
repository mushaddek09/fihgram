package com.example.api;

import com.example.fihgram.ResponseModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("datafetch.php")
    Call<List<ResponseModel>> getdata();

}
