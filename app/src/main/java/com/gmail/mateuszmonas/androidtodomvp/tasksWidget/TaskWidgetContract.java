package com.gmail.mateuszmonas.androidtodomvp.tasksWidget;


import com.gmail.mateuszmonas.androidtodomvp.BasePresenter;
import com.gmail.mateuszmonas.androidtodomvp.BaseView;
import com.gmail.mateuszmonas.androidtodomvp.data.objects.Task;

import java.util.List;

public interface TaskWidgetContract {

    interface View extends BaseView<Presenter>{

        void startApplication();

        void showTasks(List<Task> tasks, boolean forceUpdate);

        void setRefreshingView(boolean refreshing);

        void updateTask(Task task, int position);

    }

    interface Presenter extends BasePresenter{

        void loadTasks(int offset, boolean forceUpdate);

        void setTaskDone(int localId);

        void setView(View view);

    }

}
