package com.gmail.mateuszmonas.androidtodomvp.data.remote;


import com.gmail.mateuszmonas.androidtodomvp.data.DataSource;
import com.google.gson.Gson;

import javax.inject.Inject;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

public class RemoteDataSource implements DataSource {

    private final Retrofit retrofit;
    private final Gson gson;
    private final OkHttpClient okHttpClient;
    private final ApiEndpoint api;

    @Inject
    RemoteDataSource(Retrofit retrofit, Gson gson, OkHttpClient okHttpClient) {
        this.retrofit = retrofit;
        this.gson = gson;
        this.okHttpClient = okHttpClient;
        this.api = retrofit.create(ApiEndpoint.class);
    }

    interface ApiEndpoint{

    }

}
