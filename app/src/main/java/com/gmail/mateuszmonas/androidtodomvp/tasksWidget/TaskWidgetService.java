package com.gmail.mateuszmonas.androidtodomvp.tasksWidget;


import android.content.Intent;
import android.widget.RemoteViewsService;

import com.gmail.mateuszmonas.androidtodomvp.ToDoApplication;

import javax.inject.Inject;

public class TaskWidgetService extends RemoteViewsService {

    @Inject
    TaskWidgetContract.Presenter presenter;

    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {
        TasksWidgetRemoteViewsFactory remoteViewsFactory = new TasksWidgetRemoteViewsFactory();
        DaggerTaskWidgetComponent.builder()
                .dataRepositoryComponent(((ToDoApplication) getApplication()).getDataRepositoryComponent())
                .taskWidgetPresenterModule(new TaskWidgetPresenterModule())
                .build().inject(remoteViewsFactory);
        return remoteViewsFactory;
    }
}
