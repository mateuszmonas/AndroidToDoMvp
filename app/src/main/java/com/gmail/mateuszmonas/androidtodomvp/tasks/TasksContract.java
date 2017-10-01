package com.gmail.mateuszmonas.androidtodomvp.tasks;


import com.gmail.mateuszmonas.androidtodomvp.BasePresenter;
import com.gmail.mateuszmonas.androidtodomvp.BaseView;
import com.gmail.mateuszmonas.androidtodomvp.data.objects.Task;

import java.util.List;

public class TasksContract {

    interface View extends BaseView<Presenter>{

        void showTasks(List<Task> tasks, boolean forceUpdate);

        void setRefreshingView(boolean refreshing);

    }

    interface Presenter extends BasePresenter{

        void loadTasks(int offset, boolean forceUpdate);

    }

}
