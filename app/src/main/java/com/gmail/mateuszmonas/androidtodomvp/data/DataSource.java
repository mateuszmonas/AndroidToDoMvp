package com.gmail.mateuszmonas.androidtodomvp.data;


import com.gmail.mateuszmonas.androidtodomvp.data.objects.Task;

import java.util.ArrayList;

public interface DataSource {

    void getTasks(CallbackServerResponse<ArrayList<Task>> callback, int offset);

    void editTask(CallbackServerResponse<Task> callback, int localId);

    void setTaskDone(CallbackServerResponse<Task> callback, int localId);

    void addNewTask(CallbackServerResponse<Task> callback);

    void deleteTasks(CallbackServerResponse<ArrayList<Task>> callback);

    interface CallbackServerResponse<T> {

        void onResponse(T response);

        void onFailure();

    }

}
