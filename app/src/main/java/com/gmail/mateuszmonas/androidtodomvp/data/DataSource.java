package com.gmail.mateuszmonas.androidtodomvp.data;


import com.gmail.mateuszmonas.androidtodomvp.data.objects.Task;

import java.util.ArrayList;

public interface DataSource {

    void getTasks(CallbackServerResponse<ArrayList<Task>> callback, int offset);

    interface CallbackServerResponse<T> {

        void onResponse(T response);

        void onFailure();

    }

}
