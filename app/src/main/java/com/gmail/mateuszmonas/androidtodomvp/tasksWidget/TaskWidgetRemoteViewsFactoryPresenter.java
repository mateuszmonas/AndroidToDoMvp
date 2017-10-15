package com.gmail.mateuszmonas.androidtodomvp.tasksWidget;


import com.gmail.mateuszmonas.androidtodomvp.data.DataRepository;
import com.gmail.mateuszmonas.androidtodomvp.data.objects.Task;
import com.gmail.mateuszmonas.androidtodomvp.utils.FragmentScope;

import java.util.ArrayList;
import java.util.Arrays;

import javax.inject.Inject;


public class TaskWidgetRemoteViewsFactoryPresenter implements TaskWidgetContract.RemoteViewsFactoryPresenter {

    private DataRepository repository;

    @Inject
    public TaskWidgetRemoteViewsFactoryPresenter(DataRepository repository) {
        this.repository = repository;
    }

    @Override
    public ArrayList<Task> loadTasks(int offset, boolean forceUpdate) {
        return new ArrayList<>(Arrays.asList(
                        new Task(1, "dsadsadsa", false),
                        new Task(2, "dsadsadsa", false),
                        new Task(3, "dsadsadsa", false),
                        new Task(4, "dsadsadsa", false),
                        new Task(5, "dsadsadsa", false),
                        new Task(6, "dsadsadsa", false),
                        new Task(7, "dsadsadsa", false),
                        new Task(8, "dsadsadsa", false),
                        new Task(9, "dsadsadsa", false))
        );
    }
}
