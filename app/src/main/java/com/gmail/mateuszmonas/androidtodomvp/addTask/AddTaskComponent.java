package com.gmail.mateuszmonas.androidtodomvp.addTask;

import com.gmail.mateuszmonas.androidtodomvp.data.DataRepositoryComponent;
import com.gmail.mateuszmonas.androidtodomvp.utils.FragmentScope;

import dagger.Component;

@FragmentScope
@Component(dependencies = DataRepositoryComponent.class, modules = AddTaskPresenterModule.class)
public interface AddTaskComponent {

    void inject(AddTaskActivity activity);

}
