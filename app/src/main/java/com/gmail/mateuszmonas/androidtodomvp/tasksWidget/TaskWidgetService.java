package com.gmail.mateuszmonas.androidtodomvp.tasksWidget;


import android.content.Intent;
import android.widget.RemoteViewsService;

import com.gmail.mateuszmonas.androidtodomvp.ToDoApplication;
import com.gmail.mateuszmonas.androidtodomvp.tasks.TasksPresenterModule;

public class TaskWidgetService extends RemoteViewsService {

    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {
        return new TasksWidgetRemoteViewsFactory();
    }
}
