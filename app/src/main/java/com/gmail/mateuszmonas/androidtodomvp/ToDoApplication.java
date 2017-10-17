package com.gmail.mateuszmonas.androidtodomvp;


import android.app.Application;
import android.arch.persistence.room.Room;

import com.gmail.mateuszmonas.androidtodomvp.data.DaggerDataRepositoryComponent;
import com.gmail.mateuszmonas.androidtodomvp.data.DataRepositoryComponent;
import com.gmail.mateuszmonas.androidtodomvp.data.DataSourceModule;
import com.gmail.mateuszmonas.androidtodomvp.data.local.TasksDatabase;
import com.gmail.mateuszmonas.androidtodomvp.utils.DatabaseModule;
import com.gmail.mateuszmonas.androidtodomvp.utils.NetModule;

public class ToDoApplication extends Application {

    private DataRepositoryComponent dataRepositoryComponent;
    private final String TASK_DATABASE = "TASK_DATABASE";

    @Override
    public void onCreate() {
        super.onCreate();

        dataRepositoryComponent = DaggerDataRepositoryComponent.builder()
                .netModule(new NetModule("placeholder", "placeholder", "https://localhost"))
                .databaseModule(new DatabaseModule(getApplicationContext(), TASK_DATABASE))
                .dataSourceModule(new DataSourceModule())
                .build();
    }

    public DataRepositoryComponent getDataRepositoryComponent() {
        return dataRepositoryComponent;
    }

}
