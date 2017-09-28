package com.gmail.mateuszmonas.androidtodomvp.tasks;


public class TasksPresenter implements TasksContract.Presenter {

    private final TasksContract.View view;

    public TasksPresenter(TasksContract.View view) {
        this.view = view;
    }

    @Override
    public void start() {

    }
}
