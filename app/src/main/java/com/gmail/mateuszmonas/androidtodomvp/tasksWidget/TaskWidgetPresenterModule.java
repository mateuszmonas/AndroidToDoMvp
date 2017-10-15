package com.gmail.mateuszmonas.androidtodomvp.tasksWidget;

import dagger.Module;
import dagger.Provides;

@Module
public class TaskWidgetPresenterModule {
    private final TaskWidgetContract.View view;

    public TaskWidgetPresenterModule(TaskWidgetContract.View view) {
        this.view = view;
    }

    @Provides
    public TaskWidgetContract.View getView() {
        return view;
    }
}
