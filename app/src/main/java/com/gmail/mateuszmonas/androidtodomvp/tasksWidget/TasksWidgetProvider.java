package com.gmail.mateuszmonas.androidtodomvp.tasksWidget;


import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RemoteViews;

import com.gmail.mateuszmonas.androidtodomvp.R;
import com.gmail.mateuszmonas.androidtodomvp.ToDoApplication;
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
    private AppWidgetManager appWidgetManager;

    public TasksWidgetProvider() {
        super();
        presenter.setView(this);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        if(appWidgetManager==null) {
            appWidgetManager = AppWidgetManager.getInstance(context);
        }
        if (intent.getAction().equals(UPDATE_TASK)){
            Bundle bundle = intent.getBundleExtra(UPDATE_TASK_BUNDLE);
            if(bundle!=null && bundle.containsKey(LOCAL_ID)){
                presenter.setTaskDone(bundle.getInt(LOCAL_ID));
            }
        }
    }

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {
        // Construct the RemoteViews object
        Intent intent = new Intent(context, TaskWidgetService.class);
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget_tasks);
        views.setRemoteAdapter(appWidgetId, intent);
        DaggerTasksWidgetComponent.builder().
                dataRepositoryComponent(((ToDoApplication) context.getApplicationContext()).getDataRepositoryComponent())
                .build();

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
    public void setPresenter(TaskWidgetContract.Presenter presenter) {

    }

    @Override
    public void startApplication() {

    }

    @Override
    public void showTasks(List<Task> tasks, boolean forceUpdate) {
        if(appWidgetManager!=null){
            int[] appWidgetIds = appWidgetManager.getAppWidgetIds(
                    new ComponentName("com.gmail.mateuszmonas.androidtodomvp.taskWidget","TasksWidgetProvider"));
            appWidgetManager.notifyAppWidgetViewDataChanged(appWidgetIds, R.id.tasksListView);
        }
    }

    @Override
    public void setRefreshingView(boolean refreshing) {

    }

    @Override
    public void updateTask(Task task, int position) {

    }
}
