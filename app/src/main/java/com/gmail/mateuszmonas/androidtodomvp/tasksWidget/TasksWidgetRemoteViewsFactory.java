package com.gmail.mateuszmonas.androidtodomvp.tasksWidget;


import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StrikethroughSpan;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import com.gmail.mateuszmonas.androidtodomvp.R;
import com.gmail.mateuszmonas.androidtodomvp.data.objects.Task;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class TasksWidgetRemoteViewsFactory implements RemoteViewsService.RemoteViewsFactory{

    private List<Task> tasks;
    @Inject
    TaskWidgetContract.Presenter presenter;

    TasksWidgetRemoteViewsFactory() {
        tasks = new ArrayList<>();
    }

    @Override
    public void onCreate() {
        presenter.start();
    }

    @Override
    public void onDataSetChanged() {
        if (presenter != null) {
            tasks=presenter.getTasks();
        }
    }

    @Override
    public void onDestroy() {
        presenter=null;
    }

    @Override
    public int getCount() {
        return tasks.size();
    }

    @Override
    public RemoteViews getViewAt(int i) {
        RemoteViews views = new RemoteViews("com.gmail.mateuszmonas.androidtodomvp", R.layout.widget_task_item);

        SpannableString taskDescription = new SpannableString(tasks.get(i).getDescription());

        if(tasks.get(i).isDone()) {
            taskDescription.setSpan(new StrikethroughSpan(), 0, tasks.get(i).getDescription().length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        }

        views.setTextViewText(R.id.taskDescription, taskDescription);

        Bundle extras = new Bundle();
        extras.putLong(TasksWidgetProvider.LOCAL_ID, tasks.get(i).getLocalId());

        Intent fillInIntent = new Intent();
        fillInIntent.putExtra(TasksWidgetProvider.UPDATE_TASK_BUNDLE, extras);

        views.setOnClickFillInIntent(R.id.widgetTaskItem, fillInIntent);
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
        return i;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }
}
