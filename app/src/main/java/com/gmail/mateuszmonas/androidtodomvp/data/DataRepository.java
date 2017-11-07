package com.gmail.mateuszmonas.androidtodomvp.data;


import com.gmail.mateuszmonas.androidtodomvp.data.local.Local;
import com.gmail.mateuszmonas.androidtodomvp.data.objects.Task;
import com.gmail.mateuszmonas.androidtodomvp.data.remote.Remote;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.MaybeObserver;
import io.reactivex.SingleObserver;

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
    public void getTasks(SingleObserver<List<Task>> observer, int offset) {
        localDataSource.getTasks(observer, offset);
    }

    @Override
    public void editTask(MaybeObserver<Task> observer, Task task) {
        localDataSource.editTask(observer, task);
    }

    @Override
    public void setTaskDone(MaybeObserver<Task> observer, long localId) {
        localDataSource.setTaskDone(observer, localId);
    }

    @Override
    public void addTask(SingleObserver<Long> observer, Task task) {
        localDataSource.addTask(observer, task);
    }

    @Override
    public void deleteTasks(SingleObserver<List<Task>> observer) {
        localDataSource.deleteTasks(observer);
    }

    @Override
    public void getTask(MaybeObserver<Task> observer, long localId) {
        localDataSource.getTask(observer, localId);
    }
}
