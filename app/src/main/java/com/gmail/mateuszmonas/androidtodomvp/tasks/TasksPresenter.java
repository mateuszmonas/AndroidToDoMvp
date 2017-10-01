package com.gmail.mateuszmonas.androidtodomvp.tasks;


import com.gmail.mateuszmonas.androidtodomvp.data.DataRepository;
import com.gmail.mateuszmonas.androidtodomvp.data.DataSource;
import com.gmail.mateuszmonas.androidtodomvp.data.objects.Task;

import java.util.ArrayList;

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
        loadTasks(0, false);
    }

    @Override
    public void loadTasks(int offset, final boolean forceUpdate) {
        view.setRefreshingView(true);
        repository.getTasks(new DataSource.CallbackServerResponse<ArrayList<Task>>() {
            @Override
            public void onResponse(ArrayList<Task> response) {
                view.setRefreshingView(false);
                view.showTasks(response, forceUpdate);
            }

            @Override
            public void onFailure() {

            }
        }, offset);
    }

    @Override
    public void setTaskDone(int localId, int position) {
    }

    @Override
    public void editTask(int localId, int position) {

    }
}
