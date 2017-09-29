package com.gmail.mateuszmonas.androidtodomvp.tasks;

import android.support.v4.app.Fragment;

public class TasksFragment extends Fragment implements TasksContract.View {

    private TasksContract.Presenter presenter;

    public TasksFragment() {
    }

    @Override
    public void setPresenter(TasksContract.Presenter presenter) {
        this.presenter=presenter;
    }

    public static TasksFragment newInstance(){
        return new TasksFragment();
    }

}
