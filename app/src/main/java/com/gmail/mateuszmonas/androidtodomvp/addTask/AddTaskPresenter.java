package com.gmail.mateuszmonas.androidtodomvp.addTask;

import android.util.Log;

import com.gmail.mateuszmonas.androidtodomvp.data.DataRepository;
import com.gmail.mateuszmonas.androidtodomvp.data.objects.Task;

import javax.inject.Inject;

import io.reactivex.MaybeObserver;
import io.reactivex.SingleObserver;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

public class AddTaskPresenter implements AddTaskContract.Presenter {

    private final String TAG = "AddTaskPresenter";
    private final AddTaskContract.View view;
    private final DataRepository repository;

    @Inject
    public AddTaskPresenter(AddTaskContract.View view, DataRepository repository) {
        this.view = view;
        this.repository = repository;
    }

    @Inject
    void setupListeners() {
        view.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void getTask(long localId) {
        repository.getTask(new MaybeObserver<Task>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onSuccess(Task task) {
                view.setDescription(task.getDescription());
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        }, localId);
    }

    @Override
    public void addTask(Task task) {
        repository.addTask(new SingleObserver<Long>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onSuccess(@NonNull Long aLong) {
                view.finishActivity();
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.e(TAG, e.getLocalizedMessage());
            }
        }, task);
    }

    @Override
    public void editTask(Task task) {
        repository.editTask(new MaybeObserver<Task>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onSuccess(@NonNull Task task) {
                view.finishActivity();
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        }, task);
    }
}
