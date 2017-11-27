package com.gmail.mateuszmonas.androidtodomvp.tasksWidget;

import com.gmail.mateuszmonas.androidtodomvp.data.DataRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class TaskWidgetRemoteViewsFactoryModule {

    @Provides
    TasksWidgetRemoteViewsFactory getFactory(DataRepository repository){
        return new TasksWidgetRemoteViewsFactory(repository);
    }

}
