package com.gmail.mateuszmonas.androidtodomvp.tasksWidget;


import com.gmail.mateuszmonas.androidtodomvp.data.DataRepository;
import com.gmail.mateuszmonas.androidtodomvp.data.DataSource;
import com.gmail.mateuszmonas.androidtodomvp.data.objects.Task;

import java.nio.channels.AsynchronousCloseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.SingleObserver;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;


public class TaskWidgetPresenter implements TaskWidgetContract.Presenter {

    private final DataRepository repository;
    private final TaskWidgetContract.View view;

    @Inject
    public TaskWidgetPresenter(DataRepository repository, TaskWidgetContract.View view) {
        this.view = view;
        this.repository = repository;
    }

    @Override
    public void start() {
    }

    @Override
    public void loadTasks(int offset, boolean forceUpdate) {
        repository.getTasks(new SingleObserver<List<Task>>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onSuccess(@NonNull List<Task> tasks) {
                view.ShowTasks(tasks);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }
        }, offset);
    }
}
