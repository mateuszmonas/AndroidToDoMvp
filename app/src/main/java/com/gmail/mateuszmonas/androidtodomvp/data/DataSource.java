package com.gmail.mateuszmonas.androidtodomvp.data;


import com.gmail.mateuszmonas.androidtodomvp.data.objects.Task;

public interface DataSource {

    void getTasks(CallbackServerResponse<Task> tasks, int offset);

    interface CallbackServerResponse<T> {

        void onResponse(T response);

        void onFailure();

    }

}
