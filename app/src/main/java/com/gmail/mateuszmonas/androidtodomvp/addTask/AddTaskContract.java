package com.gmail.mateuszmonas.androidtodomvp.addTask;


import com.gmail.mateuszmonas.androidtodomvp.BasePresenter;
import com.gmail.mateuszmonas.androidtodomvp.BaseView;
import com.gmail.mateuszmonas.androidtodomvp.data.objects.Task;

public interface AddTaskContract {

    interface Presenter extends BasePresenter{

        void addTask(Task task);

        void editTask(Task task);

        void getTask(long localId);

    }

    interface View extends BaseView<Presenter>{

        void setDescription(String description);

        void finishActivity();

    }

}
