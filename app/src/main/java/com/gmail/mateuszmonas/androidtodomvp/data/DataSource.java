package com.gmail.mateuszmonas.androidtodomvp.data;


import com.gmail.mateuszmonas.androidtodomvp.data.objects.Task;

import java.util.List;

import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.SingleObserver;

public interface DataSource {

    void getTasks(SingleObserver<List<Task>> observer);

    void editTask(MaybeObserver<Task> observer, Task task);

    void setTaskDone(MaybeObserver<Task> observer, long localId);

    void addTask(SingleObserver<Long> observer, Task task);

    void deleteTasks(SingleObserver<List<Task>> observer);

    void getTask(MaybeObserver<Task> observer, long localId);

    void subscribeToTasks(FlowableSubscriber<List<Task>> subscriber);

}
