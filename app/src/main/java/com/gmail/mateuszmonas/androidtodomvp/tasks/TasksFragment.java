package com.gmail.mateuszmonas.androidtodomvp.tasks;


public class TasksFragment implements TasksContract.View {

    private TasksContract.Presenter presenter;

    @Override
    public void setPresenter(TasksContract.Presenter presenter) {
        this.presenter=presenter;
    }
}
