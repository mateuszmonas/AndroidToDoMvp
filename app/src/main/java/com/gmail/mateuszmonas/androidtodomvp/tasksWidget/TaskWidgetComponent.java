package com.gmail.mateuszmonas.androidtodomvp.tasksWidget;

import com.gmail.mateuszmonas.androidtodomvp.data.DataRepositoryComponent;
import com.gmail.mateuszmonas.androidtodomvp.utils.FragmentScope;

import dagger.Component;

@FragmentScope
@Component(dependencies = DataRepositoryComponent.class, modules = TaskWidgetPresenterModule.class)
public interface TaskWidgetComponent {

    void inject(TasksWidgetRemoteViewsFactory remoteViewsFactory);

}
