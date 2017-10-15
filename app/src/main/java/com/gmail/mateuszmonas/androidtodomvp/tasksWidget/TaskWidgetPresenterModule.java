package com.gmail.mateuszmonas.androidtodomvp.tasksWidget;

import com.gmail.mateuszmonas.androidtodomvp.data.DataRepository;

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

    @Provides
    public TaskWidgetContract.Presenter getPresenter(DataRepository repository){
        return new TaskWidgetPresenter(repository, view);
    }

}
