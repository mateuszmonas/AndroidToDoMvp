package com.gmail.mateuszmonas.androidtodomvp.tasks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.gmail.mateuszmonas.androidtodomvp.R;
import com.gmail.mateuszmonas.androidtodomvp.ToDoApplication;
import com.gmail.mateuszmonas.androidtodomvp.utils.ActivityUtils;

import javax.inject.Inject;

public class TasksActivity extends AppCompatActivity {

    @Inject
    TasksPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);

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
                .build()
                .inject(this);
    }
}
