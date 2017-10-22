package com.gmail.mateuszmonas.androidtodomvp.data.local;


import com.gmail.mateuszmonas.androidtodomvp.data.DataSource;
import com.gmail.mateuszmonas.androidtodomvp.data.objects.Task;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.MaybeObserver;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
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
    public void setTaskDone(MaybeObserver<Task> observer, long localId) {

    }

    @Override
    public void addTask(final SingleObserver<Long> observer, Task task) {
        Single.just(task).subscribeOn(Schedulers.newThread())
                .subscribe(new SingleObserver<Task>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        observer.onSubscribe(d);
                    }

                    @Override
                    public void onSuccess(@NonNull Task task) {
                        tasksDatabase.taskDao().addTask(task);
                        observer.onSuccess(task.getLocalId());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        observer.onError(e);
                    }
                });
    }

    @Override
    public void deleteTasks(SingleObserver<List<Task>> observer) {

    }
}
