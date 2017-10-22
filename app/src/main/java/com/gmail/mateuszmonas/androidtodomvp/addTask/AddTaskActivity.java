package com.gmail.mateuszmonas.androidtodomvp.addTask;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.gmail.mateuszmonas.androidtodomvp.R;
import com.gmail.mateuszmonas.androidtodomvp.ToDoApplication;
import com.gmail.mateuszmonas.androidtodomvp.utils.ActivityUtils;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddTaskActivity extends AppCompatActivity{

    @Inject AddTaskPresenter presenter;
    private static final String EXTRA_LOCAL_ID = "LOCAL_ID";
    private Integer localId = null;
    @BindView(R.id.confirm)
    ImageButton confirm;

    public static Intent createIntent(Context context, long localId){
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

        Bundle extras = getIntent().getExtras();
        if(extras!=null){
            if(extras.containsKey(EXTRA_LOCAL_ID)){
                localId=extras.getInt(EXTRA_LOCAL_ID);
            }
        }

        AddTaskFragment addTaskFragment = (AddTaskFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);
        if(addTaskFragment==null){
            if(localId==null) {
                addTaskFragment = AddTaskFragment.newInstance();
            } else {
                addTaskFragment = AddTaskFragment.newInstance(localId);
            }
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), addTaskFragment, R.id.contentFrame);
        }

        DaggerAddTaskComponent.builder().
                dataRepositoryComponent(((ToDoApplication) getApplication()).getDataRepositoryComponent())
                .addTaskPresenterModule(new AddTaskPresenterModule(addTaskFragment))
                .build()
                .inject(this);


    }

    void setConfirmNewTaskListener(View.OnClickListener listener){
        confirm.setOnClickListener(listener);
    }

    @OnClick(R.id.cancel)
    void cancelNewTask(){
        super.onBackPressed();
    }
}
