package com.gmail.mateuszmonas.androidtodomvp.data.remote;


import com.gmail.mateuszmonas.androidtodomvp.data.DataSource;
import com.gmail.mateuszmonas.androidtodomvp.data.objects.Task;
import com.google.gson.Gson;

import java.util.ArrayList;

import javax.inject.Inject;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

public class RemoteDataSource implements DataSource {

    private final Retrofit retrofit;
    private final Gson gson;
    private final OkHttpClient okHttpClient;
    private final ApiEndpoint api;

    @Inject
    public RemoteDataSource(Retrofit retrofit, Gson gson, OkHttpClient okHttpClient) {
        this.retrofit = retrofit;
        this.gson = gson;
        this.okHttpClient = okHttpClient;
        this.api = retrofit.create(ApiEndpoint.class);
    }

    @Override
    public void getTasks(CallbackServerResponse<ArrayList<Task>> callback, int offset) {
    }

    @Override
    public void editTask(CallbackServerResponse<Task> callback, Task task) {

    }

    @Override
    public void setTaskDone(CallbackServerResponse<Task> callback, int localId) {

    }

    @Override
    public void addTask(CallbackServerResponse<Task> callback, Task task) {

    }

    @Override
    public void deleteTasks(CallbackServerResponse<ArrayList<Task>> callback) {

    }

    interface ApiEndpoint{

    }

}
