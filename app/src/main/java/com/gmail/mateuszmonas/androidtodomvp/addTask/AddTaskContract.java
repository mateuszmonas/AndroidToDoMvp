package com.gmail.mateuszmonas.androidtodomvp.addTask;


import com.gmail.mateuszmonas.androidtodomvp.BasePresenter;
import com.gmail.mateuszmonas.androidtodomvp.BaseView;
import com.gmail.mateuszmonas.androidtodomvp.data.objects.Task;

public interface AddTaskContract {

    interface Presenter extends BasePresenter{

        void addTask(Task task);

    }

    interface View extends BaseView<Presenter>{

    }

}
