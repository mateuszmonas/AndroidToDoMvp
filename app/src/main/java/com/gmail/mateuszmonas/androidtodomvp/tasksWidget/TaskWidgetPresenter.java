package com.gmail.mateuszmonas.androidtodomvp.tasksWidget;


import com.gmail.mateuszmonas.androidtodomvp.data.DataRepository;
import com.gmail.mateuszmonas.androidtodomvp.data.objects.Task;

import org.reactivestreams.Subscription;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.FlowableSubscriber;
import io.reactivex.SingleObserver;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;


public class TaskWidgetPresenter implements TaskWidgetContract.Presenter {

    private final DataRepository repository;
    private final List<Task> tasks;

    @Inject
    public TaskWidgetPresenter(DataRepository repository) {
        this.repository = repository;
        tasks=new ArrayList<>();
    }

    @Override
    public void start() {
        loadTasks();
        repository.subscribeToTasks(new FlowableSubscriber<Object>() {
            @Override
            public void onSubscribe(Subscription s) {
                s.request(Long.MAX_VALUE);
            }

            @Override
            public void onNext(Object o) {
                loadTasks();
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    private void loadTasks() {
        repository.getTasks(new SingleObserver<List<Task>>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onSuccess(@NonNull List<Task> tasks) {
                changeTasks(tasks);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }
        });
    }

    @Override
    public List<Task> getTasks() {
        return tasks;
    }

    private void changeTasks(List<Task> tasks){
        this.tasks.clear();
        this.tasks.addAll(tasks);
    }
}
