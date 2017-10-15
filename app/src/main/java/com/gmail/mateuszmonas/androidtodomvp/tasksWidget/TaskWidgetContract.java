package com.gmail.mateuszmonas.androidtodomvp.tasksWidget;


import com.gmail.mateuszmonas.androidtodomvp.BasePresenter;
import com.gmail.mateuszmonas.androidtodomvp.BaseView;
import com.gmail.mateuszmonas.androidtodomvp.data.objects.Task;

import java.util.ArrayList;
import java.util.List;

public interface TaskWidgetContract {

    interface View{

        void setRefreshingView(boolean refreshing);

        void showTasks();

    }

    interface Presenter extends BasePresenter{

        void setTaskDone(int localId);

    }

    interface  RemoteViewsFactoryPresenter{

        ArrayList<Task> loadTasks(int offset, boolean forceUpdate);

    }

}
