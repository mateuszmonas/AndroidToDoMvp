package com.gmail.mateuszmonas.androidtodomvp.tasksWidget;


import com.gmail.mateuszmonas.androidtodomvp.data.DataRepository;

import javax.inject.Inject;

public class TaskWidgetPresenter implements TaskWidgetContract.Presenter {

    private TaskWidgetContract.View view;
    private final DataRepository repository;

    @Inject
    TaskWidgetPresenter(DataRepository repository) {
        this.repository = repository;
    }

    @Override
    public void start() {

    }

    @Override
    public void setTaskDone(int localId) {

    }
}
