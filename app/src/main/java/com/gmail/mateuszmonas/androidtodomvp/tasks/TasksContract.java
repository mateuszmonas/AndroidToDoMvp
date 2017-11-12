package com.gmail.mateuszmonas.androidtodomvp.tasks;


import com.gmail.mateuszmonas.androidtodomvp.BasePresenter;
import com.gmail.mateuszmonas.androidtodomvp.BaseView;
import com.gmail.mateuszmonas.androidtodomvp.data.objects.Task;

import java.util.List;

public interface TasksContract {

    interface View extends BaseView<Presenter>{

        void startEditTaskActivity(long localId);

        void showTasks(List<Task> tasks, boolean forceUpdate);

        void setRefreshingView(boolean refreshing);

        void updateTask(Task task, int position);

    }

    interface Presenter extends BasePresenter{

        void loadTasks(boolean forceUpdate);

        void setTaskDone(long localId, int position);

        void editTask(long localId);

        void deleteTasks();

    }

}
