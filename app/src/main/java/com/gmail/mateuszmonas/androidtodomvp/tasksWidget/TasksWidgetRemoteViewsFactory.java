package com.gmail.mateuszmonas.androidtodomvp.tasksWidget;


import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import com.gmail.mateuszmonas.androidtodomvp.data.objects.Task;

import java.util.ArrayList;
import java.util.List;

public class TasksWidgetRemoteViewsFactory implements RemoteViewsService.RemoteViewsFactory {

    private final ArrayList<Task> tasks;

    public TasksWidgetRemoteViewsFactory() {
        tasks = new ArrayList<>();
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onDataSetChanged() {

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
        return null;
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
        return true;
    }

}
