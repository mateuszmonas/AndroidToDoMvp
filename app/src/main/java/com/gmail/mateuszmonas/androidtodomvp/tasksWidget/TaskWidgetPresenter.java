package com.gmail.mateuszmonas.androidtodomvp.tasksWidget;


import com.gmail.mateuszmonas.androidtodomvp.data.DataRepository;

import javax.inject.Inject;

public class TaskWidgetPresenter implements TaskWidgetContract.Presenter {

    private TaskWidgetContract.View view;
    private final DataRepository repository;

    @Inject
    public TaskWidgetPresenter(DataRepository repository) {
        this.repository = repository;
    }

    @Override
    public void start() {

    }

    @Override
    public void setView(TaskWidgetContract.View view) {
        this.view=view;
    }

    @Override
    public void loadTasks(int offset, boolean forceUpdate) {

    }

    @Override
    public void setTaskDone(int localId) {

    }
}
