package com.gmail.mateuszmonas.androidtodomvp.tasksWidget;


import android.content.Intent;
import android.widget.RemoteViewsService;

import com.gmail.mateuszmonas.androidtodomvp.ToDoApplication;

import javax.inject.Inject;

public class TaskWidgetService extends RemoteViewsService {

    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {
        TasksWidgetRemoteViewsFactory remoteViewsFactory = DaggerTaskWidgetRemoteViewsFactoryComponent.builder()
                .dataRepositoryComponent(((ToDoApplication) getApplication()).getDataRepositoryComponent())
                .build().getFactory();

        return remoteViewsFactory;
    }
}
