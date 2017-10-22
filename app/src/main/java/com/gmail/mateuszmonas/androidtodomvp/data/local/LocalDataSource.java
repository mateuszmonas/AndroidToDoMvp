package com.gmail.mateuszmonas.androidtodomvp.data.local;


import com.gmail.mateuszmonas.androidtodomvp.data.DataSource;
import com.gmail.mateuszmonas.androidtodomvp.data.objects.Task;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.MaybeObserver;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class LocalDataSource implements DataSource {

    private final TasksDatabase tasksDatabase;

    @Inject
    public LocalDataSource(TasksDatabase tasksDatabase) {
        this.tasksDatabase = tasksDatabase;
    }

    @Override
    public void getTasks(SingleObserver<List<Task>> observer, int offset) {
        tasksDatabase.taskDao().getTasks()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    @Override
    public void editTask(MaybeObserver<Task> observer, Task task) {

    }

    @Override
    public void setTaskDone(MaybeObserver<Task> observer, int localId) {

    }

    @Override
    public void addTask(MaybeObserver<Task> observer, Task task) {
        tasksDatabase.taskDao().addTask(task);
    }

    @Override
    public void deleteTasks(SingleObserver<List<Task>> observer) {

    }
}
