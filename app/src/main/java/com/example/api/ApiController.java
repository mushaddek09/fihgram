package com.example.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiController {

    private static final String url = "https://fihgram.000webhostapp.com/instagram/";
    private static ApiController clientobject;
    private static Retrofit retrofit;



    ApiController()
    {

        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }


    public static  synchronized ApiController getInstance()
    {

        if (clientobject==null)

            clientobject = new ApiController();

        return clientobject;

    }

    public ApiService getApi()
    {

        return  retrofit.create(ApiService.class);
    }



}
