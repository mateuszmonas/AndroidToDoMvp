package com.gmail.mateuszmonas.androidtodomvp.data;


import com.gmail.mateuszmonas.androidtodomvp.data.local.Local;
import com.gmail.mateuszmonas.androidtodomvp.data.objects.Task;
import com.gmail.mateuszmonas.androidtodomvp.data.remote.Remote;

import java.util.ArrayList;

import javax.inject.Inject;

public class DataRepository implements DataSource {

    private DataSource remoteDataSource;
    private DataSource localDataSource;

    @Inject
    public DataRepository(@Remote DataSource remoteDataSource, @Local DataSource localDataSource) {
        this.remoteDataSource = remoteDataSource;
        this.localDataSource = localDataSource;
    }

    @Override
    public void getTasks(CallbackServerResponse<ArrayList<Task>> callback, int offset) {
        //dummy data
        ArrayList<Task> tasks = new ArrayList<>();
        tasks.add(new Task("asdasd", false));
        tasks.add(new Task("asdasd", false));
        tasks.add(new Task("asdasd", false));
        tasks.add(new Task("asdasd", false));
        tasks.add(new Task("asdasd", false));
        callback.onResponse(tasks);
    }
}
