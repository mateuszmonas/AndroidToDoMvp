package com.gmail.mateuszmonas.androidtodomvp.data;


import com.gmail.mateuszmonas.androidtodomvp.data.objects.Task;

import java.util.ArrayList;

public interface DataSource {

    void getTasks(CallbackServerResponse<ArrayList<Task>> callback, int offset);

    void editTask(CallbackServerResponse<Task> callback, Task task);

    void setTaskDone(CallbackServerResponse<Task> callback, int localId);

    void addTask(CallbackServerResponse<Task> callback, Task task);

    void deleteTasks(CallbackServerResponse<ArrayList<Task>> callback);

    interface CallbackServerResponse<T> {

        void onResponse(T response);

        void onFailure();

    }

}
