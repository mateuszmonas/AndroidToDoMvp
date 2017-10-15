package com.gmail.mateuszmonas.androidtodomvp.tasksWidget;


import com.gmail.mateuszmonas.androidtodomvp.data.DataRepository;
import com.gmail.mateuszmonas.androidtodomvp.data.DataSource;
import com.gmail.mateuszmonas.androidtodomvp.data.objects.Task;

import java.util.ArrayList;
import java.util.Arrays;

import javax.inject.Inject;


public class TaskWidgetPresenter implements TaskWidgetContract.Presenter {

    private final DataRepository repository;
    private final TaskWidgetContract.View view;

    @Inject
    public TaskWidgetPresenter(DataRepository repository, TaskWidgetContract.View view) {
        this.view = view;
        this.repository = repository;
    }

    @Override
    public void start() {

    }

    @Override
    public void loadTasks(int offset, boolean forceUpdate) {
        repository.getTasks(new DataSource.CallbackServerResponse<ArrayList<Task>>() {
            @Override
            public void onResponse(ArrayList<Task> response) {
                view.ShowTasks(response);
            }

            @Override
            public void onFailure() {

            }
        }, offset);
    }
}
