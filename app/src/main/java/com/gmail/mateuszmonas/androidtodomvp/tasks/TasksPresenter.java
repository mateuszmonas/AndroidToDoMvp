package com.gmail.mateuszmonas.androidtodomvp.tasks;


import com.gmail.mateuszmonas.androidtodomvp.data.DataRepository;
import com.gmail.mateuszmonas.androidtodomvp.data.DataSource;
import com.gmail.mateuszmonas.androidtodomvp.data.objects.Task;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.MaybeObserver;
import io.reactivex.SingleObserver;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

public class TasksPresenter implements TasksContract.Presenter {

    private final TasksContract.View view;
    private final DataRepository repository;

    @Inject
    public TasksPresenter(DataRepository repository, TasksContract.View view) {
        this.view = view;
        this.repository = repository;
    }

    @Inject
    void setupListeners() {
        view.setPresenter(this);
    }

    @Override
    public void start() {
        loadTasks(0, false);
    }

    @Override
    public void loadTasks(int offset, final boolean forceUpdate) {
        view.setRefreshingView(true);
        repository.getTasks(new SingleObserver<List<Task>>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onSuccess(@NonNull List<Task> tasks) {
                view.setRefreshingView(false);
                view.showTasks(tasks, forceUpdate);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }
        }, offset);
    }

    @Override
    public void setTaskDone(int localId, final int position) {
        repository.setTaskDone(new MaybeObserver<Task>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onSuccess(@NonNull Task task) {
                view.updateTask(task, position);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        }, localId);
    }

    @Override
    public void editTask(int localId) {
        view.startEditTaskActivity(localId);
    }

    @Override
    public void deleteTasks() {
        repository.deleteTasks(new SingleObserver<List<Task>>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onSuccess(@NonNull List<Task> tasks) {
                view.showTasks(tasks, true);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }
        });
    }
}
