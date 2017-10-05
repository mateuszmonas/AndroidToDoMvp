package com.gmail.mateuszmonas.androidtodomvp.addTask;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.gmail.mateuszmonas.androidtodomvp.R;
import com.gmail.mateuszmonas.androidtodomvp.ToDoApplication;
import com.gmail.mateuszmonas.androidtodomvp.utils.ActivityUtils;

public class AddTaskActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        AddTaskFragment addTaskFragment = (AddTaskFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);
        if(addTaskFragment==null){
            addTaskFragment=AddTaskFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), addTaskFragment, R.id.contentFrame);
        }

        DaggerAddTaskComponent.builder().
                dataRepositoryComponent(((ToDoApplication) getApplication()).getDataRepositoryComponent())
                .addTaskPresenterModule(new AddTaskPresenterModule(addTaskFragment))
                .build()
                .inject(this);
    }
}
