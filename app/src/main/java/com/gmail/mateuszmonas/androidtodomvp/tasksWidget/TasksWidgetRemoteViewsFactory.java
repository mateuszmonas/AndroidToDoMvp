package com.gmail.mateuszmonas.androidtodomvp.tasksWidget;


import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StrikethroughSpan;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import com.gmail.mateuszmonas.androidtodomvp.R;
import com.gmail.mateuszmonas.androidtodomvp.data.DataRepository;
import com.gmail.mateuszmonas.androidtodomvp.data.objects.Task;

import org.reactivestreams.Subscription;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.FlowableSubscriber;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

public class TasksWidgetRemoteViewsFactory implements RemoteViewsService.RemoteViewsFactory{

    private List<Task> tasks = new ArrayList<>();
    private DataRepository repository;

    @Inject
    TasksWidgetRemoteViewsFactory(DataRepository repository) {
        this.repository=repository;
    }

    @Override
    public void onCreate() {
        repository.getTasks(new SingleObserver<List<Task>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onSuccess(List<Task> response) {
                tasks=response;
            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }

    @Override
    public void onDataSetChanged() {
        repository.subscribeToTasks(new FlowableSubscriber<List<Task>>() {
            @Override
            public void onSubscribe(Subscription s) {
                s.request(Long.MAX_VALUE);
            }

            @Override
            public void onNext(List<Task> response) {
                tasks=response;
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onComplete() {

            }
        });
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
