package com.gmail.mateuszmonas.androidtodomvp.tasks;


import com.gmail.mateuszmonas.androidtodomvp.BasePresenter;
import com.gmail.mateuszmonas.androidtodomvp.BaseView;
import com.gmail.mateuszmonas.androidtodomvp.data.objects.Task;

import java.util.List;

public interface TasksContract {

    interface View extends BaseView<Presenter>{

        void startEditTaskActivity(int localId);

        void showTasks(List<Task> tasks, boolean forceUpdate);

        void setRefreshingView(boolean refreshing);

        void updateTask(Task task, int position);

    }

    interface Presenter extends BasePresenter{

        void loadTasks(int offset, boolean forceUpdate);

        void setTaskDone(int localId, int position);

        void editTask(int localId);

        void deleteTasks();

    }

}
