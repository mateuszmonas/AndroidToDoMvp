package com.gmail.mateuszmonas.androidtodomvp.data.local;


import com.gmail.mateuszmonas.androidtodomvp.data.DataSource;
import com.gmail.mateuszmonas.androidtodomvp.data.objects.Task;

import java.util.ArrayList;

import javax.inject.Inject;

public class LocalDataSource implements DataSource {

    @Inject
    public LocalDataSource() {
    }

    @Override
    public void getTasks(CallbackServerResponse<ArrayList<Task>> callback, int offset) {

    }

    @Override
    public void editTask(CallbackServerResponse<Task> callback, Task task) {

    }

    @Override
    public void setTaskDone(CallbackServerResponse<Task> callback, int localId) {

    }

    @Override
    public void addTask(CallbackServerResponse<Task> callback, Task task) {

    }

    @Override
    public void deleteTasks(CallbackServerResponse<ArrayList<Task>> callback) {

    }
}
