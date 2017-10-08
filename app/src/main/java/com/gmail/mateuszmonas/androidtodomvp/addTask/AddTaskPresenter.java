package com.gmail.mateuszmonas.androidtodomvp.addTask;


import com.gmail.mateuszmonas.androidtodomvp.data.DataRepository;

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
}
