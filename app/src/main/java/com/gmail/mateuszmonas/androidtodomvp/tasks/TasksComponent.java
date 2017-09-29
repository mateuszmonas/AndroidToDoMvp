package com.gmail.mateuszmonas.androidtodomvp.tasks;

import com.gmail.mateuszmonas.androidtodomvp.data.DataRepositoryComponent;
import com.gmail.mateuszmonas.androidtodomvp.utils.FragmentScope;

import dagger.Component;

@FragmentScope
@Component(dependencies = DataRepositoryComponent.class, modules = TasksPresenterModule.class)
public interface TasksComponent {

    void inject(TasksActivity activity);

}
