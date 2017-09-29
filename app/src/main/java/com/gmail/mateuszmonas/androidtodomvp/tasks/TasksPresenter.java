package com.gmail.mateuszmonas.androidtodomvp.tasks;


import com.gmail.mateuszmonas.androidtodomvp.data.DataRepository;

import javax.inject.Inject;

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

    }
}
