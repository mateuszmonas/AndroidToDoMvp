package com.gmail.mateuszmonas.androidtodomvp.addTask;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.gmail.mateuszmonas.androidtodomvp.R;
import com.gmail.mateuszmonas.androidtodomvp.ToDoApplication;
import com.gmail.mateuszmonas.androidtodomvp.utils.ActivityUtils;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddTaskActivity extends AppCompatActivity{

    private static final String EXTRA_LOCAL_ID = "LOCAL_ID";

    public static Intent createIntent(Context context, int localId){
        Intent intent = new Intent(context, AddTaskActivity.class);
        intent.putExtra(EXTRA_LOCAL_ID, localId);
        return intent;
    }

    public static Intent createIntent(Context context){
        return new Intent(context, AddTaskActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        ButterKnife.bind(this);

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

    @OnClick(R.id.confirm)
    void confirmNewTask(){
        // TODO: 10/8/17
    }

    @OnClick(R.id.cancel)
    void cancelNewTask(){
        super.onBackPressed();
    }
}