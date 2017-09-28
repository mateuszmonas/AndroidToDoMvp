package com.gmail.mateuszmonas.androidtodomvp.tasks;

import dagger.Module;
import dagger.Provides;

@Module
public class TasksPresenterModule {

    private final TasksContract.View view;

    public TasksPresenterModule(TasksContract.View view){
        this.view = view;
    }

    @Provides
    public TasksContract.View getView(){
        return view;
    }

}
