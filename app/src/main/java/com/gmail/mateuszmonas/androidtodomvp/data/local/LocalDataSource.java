package com.gmail.mateuszmonas.androidtodomvp.data.local;


import com.gmail.mateuszmonas.androidtodomvp.data.DataSource;
import com.gmail.mateuszmonas.androidtodomvp.data.objects.Task;

import java.util.List;

import javax.inject.Inject;

public class LocalDataSource implements DataSource {

    private final TasksDatabase tasksDatabase;

    @Inject
    public LocalDataSource(TasksDatabase tasksDatabase) {
        this.tasksDatabase = tasksDatabase;
    }

    @Override
    public void getTasks(final CallbackServerResponse<List<Task>> callback, int offset) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                callback.onResponse(tasksDatabase.taskDao().getTasks());
            }
        }).start();
    }

    @Override
    public void editTask(CallbackServerResponse<Task> callback, Task task) {

    }

    @Override
    public void setTaskDone(CallbackServerResponse<Task> callback, int localId) {

    }

    @Override
    public void addTask(final CallbackServerResponse<Task> callback, final Task task) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                tasksDatabase.taskDao().addTask(task);
                callback.onResponse(tasksDatabase.taskDao().getTask(task.getLocalId()));

            }
        }).start();
    }

    @Override
    public void deleteTasks(CallbackServerResponse<List<Task>> callback) {

    }
}
