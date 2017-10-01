package com.gmail.mateuszmonas.androidtodomvp.tasks;


import com.gmail.mateuszmonas.androidtodomvp.data.DataRepository;
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

    }

    @Override
    public void loadTasks(int offset, boolean forceUpdate) {
        view.setRefreshingView(true);
        //dummy data
        ArrayList<Task> tasks = new ArrayList<>();
        tasks.add(new Task("asdasd", false));
        tasks.add(new Task("asdasd", false));
        tasks.add(new Task("asdasd", false));
        tasks.add(new Task("asdasd", false));
        view.setRefreshingView(false);
        view.showTasks(tasks, forceUpdate);
    }
}
