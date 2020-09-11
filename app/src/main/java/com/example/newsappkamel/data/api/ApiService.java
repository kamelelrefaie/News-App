package com.example.newsappkamel.data.api;

import com.example.newsappkamel.data.model.GeneralRequest;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("top-headlines")
     Call<GeneralRequest> getNews(@Query("country") String cn
            , @Query("apiKey") String Key);

    @GET("top-headlines")
     Call<GeneralRequest> getSpecificNews(@Query("country") String cn
            , @Query("category") String Cat
            , @Query("apiKey") String Key);

}
