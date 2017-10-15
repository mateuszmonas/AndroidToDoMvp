package com.gmail.mateuszmonas.androidtodomvp.tasksWidget;


import com.gmail.mateuszmonas.androidtodomvp.data.DataRepository;
import com.gmail.mateuszmonas.androidtodomvp.data.objects.Task;

import java.util.ArrayList;

public class TaskWidgetRemoteViewsFactoryPresenter implements TaskWidgetContract.RemoteViewsFactoryPresenter {

    private DataRepository repository;

    public TaskWidgetRemoteViewsFactoryPresenter(DataRepository repository) {
        this.repository = repository;
    }

    @Override
    public ArrayList<Task> loadTasks(int offset) {
        return null;
    }
}
