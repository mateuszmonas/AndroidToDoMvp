package com.gmail.mateuszmonas.androidtodomvp.tasksWidget;


import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.RemoteViews;

import com.gmail.mateuszmonas.androidtodomvp.R;
import com.gmail.mateuszmonas.androidtodomvp.ToDoApplication;
import com.gmail.mateuszmonas.androidtodomvp.data.DataSource;
import com.gmail.mateuszmonas.androidtodomvp.data.objects.Task;
import com.gmail.mateuszmonas.androidtodomvp.tasks.TasksActivity;

import java.util.List;

import javax.inject.Inject;

public class TasksWidgetProvider extends AppWidgetProvider implements TaskWidgetContract.View {

    public static final String UPDATE_TASK = "UPDATE_TASK";
    public static final String UPDATE_TASK_BUNDLE = "UPDATE_TASK_BUNDLE";
    public static final String LOCAL_ID = "LOCAL_ID";
    @Inject
    TaskWidgetPresenter presenter;
    private ComponentName name;

    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        this.name = new ComponentName(context, TasksWidgetProvider.class);
        final AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
        if (intent.getAction().equals(UPDATE_TASK)) {
            Bundle bundle = intent.getBundleExtra(UPDATE_TASK_BUNDLE);
            if (bundle != null && bundle.containsKey(LOCAL_ID)) {
                ((ToDoApplication) context.getApplicationContext()).getDataRepositoryComponent().getDataRepository()
                        .setTaskDone(new DataSource.CallbackServerResponse<Task>() {
                            @Override
                            public void onResponse(Task response) {
                                showTasks(appWidgetManager);
                            }

                            @Override
                            public void onFailure() {

                            }
                        }, bundle.getInt(LOCAL_ID));
            }
        }
    }

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {

        // Construct the RemoteViews object
        Intent intent = new Intent(context, TaskWidgetService.class);
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget_tasks);
        views.setRemoteAdapter(R.id.tasksListView, intent);

        Intent taskIntent = new Intent(context, TasksWidgetProvider.class);
        taskIntent.setAction(TasksWidgetProvider.UPDATE_TASK);
        taskIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId);
        PendingIntent taskPendingIntent = PendingIntent.getBroadcast(context, 0, taskIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        views.setPendingIntentTemplate(R.id.tasksListView, taskPendingIntent);

        Intent launchIntent = new Intent(context, TasksActivity.class);
        PendingIntent launchPendingIntent = PendingIntent.getActivity(context, 0, launchIntent, 0);
        views.setOnClickPendingIntent(R.id.widget_title, launchPendingIntent);

        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
        super.onUpdate(context, appWidgetManager, appWidgetIds);
    }

    @Override
    public void setRefreshingView(boolean refreshing) {

    }

    @Override
    public void showTasks() {
    }

    private void showTasks(AppWidgetManager appWidgetManager) {
        int[] appWidgetIds = appWidgetManager.getAppWidgetIds(name);
        appWidgetManager.notifyAppWidgetViewDataChanged(appWidgetIds, R.id.tasksListView);
    }
}