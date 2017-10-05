package com.gmail.mateuszmonas.androidtodomvp.addTask;

import dagger.Module;
import dagger.Provides;

@Module
public class AddTaskPresenterModule {
    private final AddTaskContract.View view;

    public AddTaskPresenterModule(AddTaskContract.View view){
        this.view=view;
    }

    @Provides
    public AddTaskContract.View getView(){
        return view;
    }
}
