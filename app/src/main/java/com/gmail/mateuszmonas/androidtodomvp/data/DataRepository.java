package com.gmail.mateuszmonas.androidtodomvp.data;


import com.gmail.mateuszmonas.androidtodomvp.data.local.Local;
import com.gmail.mateuszmonas.androidtodomvp.data.objects.Task;
import com.gmail.mateuszmonas.androidtodomvp.data.remote.Remote;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

//test implementation
// TODO: 10/8/17
@Singleton
public class DataRepository implements DataSource {

    private DataSource remoteDataSource;
    private DataSource localDataSource;

    @Inject
    DataRepository(@Remote DataSource remoteDataSource, @Local DataSource localDataSource) {
        this.remoteDataSource = remoteDataSource;
        this.localDataSource = localDataSource;
    }

    @Override
    public void getTasks(final CallbackServerResponse<List<Task>> callback, int offset) {
        localDataSource.getTasks(new CallbackServerResponse<List<Task>>() {
            @Override
            public void onResponse(List<Task> response) {
                callback.onResponse(response);
            }

            @Override
            public void onFailure() {

            }
        }, offset);
    }

    @Override
    public void editTask(CallbackServerResponse<Task> callback, Task task) {
    }

    @Override
    public void setTaskDone(CallbackServerResponse<Task> callback, int localId) {
    }

    @Override
    public void addTask(final CallbackServerResponse<Task> callback, Task task) {
        localDataSource.addTask(new CallbackServerResponse<Task>() {
            @Override
            public void onResponse(Task response) {
               callback.onResponse(response);
            }

            @Override
            public void onFailure() {

            }
        }, task);
    }

    @Override
    public void deleteTasks(CallbackServerResponse<List<Task>> callback) {
    }
}
