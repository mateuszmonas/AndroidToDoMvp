package com.gmail.mateuszmonas.androidtodomvp.tasksWidget;


import com.gmail.mateuszmonas.androidtodomvp.BasePresenter;
import com.gmail.mateuszmonas.androidtodomvp.data.objects.Task;

import java.util.List;

public interface TaskWidgetContract {

    interface Presenter extends BasePresenter{

        List<Task> getTasks();

    }

}
