package com.gmail.mateuszmonas.androidtodomvp.tasks;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.gmail.mateuszmonas.androidtodomvp.R;
import com.gmail.mateuszmonas.androidtodomvp.ToDoApplication;
import com.gmail.mateuszmonas.androidtodomvp.addTask.AddTaskActivity;
import com.gmail.mateuszmonas.androidtodomvp.tasksWidget.TasksWidgetProvider;
import com.gmail.mateuszmonas.androidtodomvp.utils.ActivityUtils;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class TasksActivity extends AppCompatActivity {

    @Inject
    TasksPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);

        ButterKnife.bind(this);

        TasksFragment tasksFragment = (TasksFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);
        if (tasksFragment == null){
            tasksFragment = TasksFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), tasksFragment, R.id.contentFrame);
        }

        DaggerTasksComponent.builder()
                .dataRepositoryComponent(
                        ((ToDoApplication) getApplication()).getDataRepositoryComponent()
                )
                .tasksPresenterModule(new TasksPresenterModule(tasksFragment))
                .build().inject(this);
    }

    @OnClick(R.id.add)
    void startAddTaskActivity(){
        Intent intent = AddTaskActivity.createIntent(getApplicationContext());
        startActivity(intent);
    }

    @OnClick(R.id.delete)
    void deleteFinishedTasks(){
        presenter.deleteTasks();
    }

    @Override
    protected void onPause() {
        ActivityUtils.updateWidget(getApplicationContext());
        super.onPause();
    }
}
