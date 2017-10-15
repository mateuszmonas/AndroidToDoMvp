package com.gmail.mateuszmonas.androidtodomvp.tasksWidget;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import com.gmail.mateuszmonas.androidtodomvp.R;
import com.gmail.mateuszmonas.androidtodomvp.data.DataRepository;
import com.gmail.mateuszmonas.androidtodomvp.data.objects.Task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

public class TasksWidgetRemoteViewsFactory implements RemoteViewsService.RemoteViewsFactory {

    private final ArrayList<Task> tasks;
    @Inject
    TaskWidgetContract.RemoteViewsFactoryPresenter presenter;

    public TasksWidgetRemoteViewsFactory() {
        tasks = new ArrayList<>(
                Arrays.asList(
                        new Task(1, "asdasd", false),
                        new Task(2, "asdasd", false),
                        new Task(3, "asdasd", false),
                        new Task(4, "asdasd", false),
                        new Task(5, "asdasd", false),
                        new Task(6, "asdasd", false),
                        new Task(7, "asdasd", false),
                        new Task(8, "asdasd", false),
                        new Task(9, "asdasd", false))
        );
    }

    @Override
    public void onCreate() {
    }

    @Override
    public void onDataSetChanged() {
        tasks.clear();
        tasks.addAll(presenter.loadTasks(0, true));
    }

    @Override
    public void onDestroy() {
    }

    @Override
    public int getCount() {
        return tasks.size();
    }

    @Override
    public RemoteViews getViewAt(int i) {
        RemoteViews views = new RemoteViews("com.gmail.mateuszmonas.androidtodomvp", R.layout.widget_task_item);
        views.setTextViewText(R.id.taskDescription, tasks.get(i).getDescription());

        Bundle extras = new Bundle();
        extras.putInt(TasksWidgetProvider.LOCAL_ID, tasks.get(i).getLocalId());

        Intent fillInIntent = new Intent();
        fillInIntent.putExtra(TasksWidgetProvider.UPDATE_TASK_BUNDLE, extras);
        views.setOnClickFillInIntent(R.id.taskDescription, fillInIntent);
        return views;
    }

    @Override
    public RemoteViews getLoadingView() {
        return null;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public long getItemId(int i) {
        return tasks.get(i).getLocalId();
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }
}
