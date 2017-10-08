package com.gmail.mateuszmonas.androidtodomvp.addTask;


import android.util.Log;

import com.gmail.mateuszmonas.androidtodomvp.data.DataRepository;
import com.gmail.mateuszmonas.androidtodomvp.data.DataSource;
import com.gmail.mateuszmonas.androidtodomvp.data.objects.Task;

import javax.inject.Inject;

public class AddTaskPresenter implements AddTaskContract.Presenter {

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
    public void addTask(Task task) {
        repository.addTask(new DataSource.CallbackServerResponse<Task>() {
            @Override
            public void onResponse(Task response) {

            }

            @Override
            public void onFailure() {

            }
        }, task);
    }
}
