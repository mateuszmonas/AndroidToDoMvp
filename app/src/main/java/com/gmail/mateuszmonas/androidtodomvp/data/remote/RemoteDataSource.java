package com.gmail.mateuszmonas.androidtodomvp.data.remote;


import com.gmail.mateuszmonas.androidtodomvp.data.DataSource;
import com.gmail.mateuszmonas.androidtodomvp.data.objects.Task;
import com.google.gson.Gson;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.SingleObserver;
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
    public void getTasks(SingleObserver<List<Task>> observer, int offset) {

    }

    @Override
    public void editTask(MaybeObserver<Task> observer, Task task) {

    }

    @Override
    public void setTaskDone(MaybeObserver<Task> observer, long localId) {

    }

    @Override
    public void addTask(SingleObserver<Long> observer, Task task) {

    }

    @Override
    public void deleteTasks(SingleObserver<List<Task>> observer) {

    }

    @Override
    public void getTask(MaybeObserver<Task> observer, long localId) {

    }

    @Override
    public void subscribeToTasks(FlowableSubscriber<Object> subscriber) {

    }

    interface ApiEndpoint{

    }

}
