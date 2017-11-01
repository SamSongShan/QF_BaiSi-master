package com.example.song.baisi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by 11355 on 2016/11/28.
 */

public class ApiManger {
    public static IApiService creatApi(String baseurl){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseurl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        IApiService iApiService = retrofit.create(IApiService.class);

        return iApiService;
    }
    public static IApiService creatStringApi(String baseurl){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseurl)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        IApiService iApiService = retrofit.create(IApiService.class);

        return iApiService;
    }
}
