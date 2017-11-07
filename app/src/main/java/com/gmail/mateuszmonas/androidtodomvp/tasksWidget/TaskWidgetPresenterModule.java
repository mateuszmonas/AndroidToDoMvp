package com.gmail.mateuszmonas.androidtodomvp.tasksWidget;

import com.gmail.mateuszmonas.androidtodomvp.data.DataRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class TaskWidgetPresenterModule {

    @Provides
    public TaskWidgetContract.Presenter getPresenter(DataRepository repository){
        return new TaskWidgetPresenter(repository);
    }

}
