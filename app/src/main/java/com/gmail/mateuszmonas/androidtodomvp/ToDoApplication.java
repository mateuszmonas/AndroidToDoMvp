package com.gmail.mateuszmonas.androidtodomvp;


import android.app.Application;

import com.gmail.mateuszmonas.androidtodomvp.data.DaggerDataRepositoryComponent;
import com.gmail.mateuszmonas.androidtodomvp.data.DataRepositoryComponent;
import com.gmail.mateuszmonas.androidtodomvp.data.DataSourceModule;
import com.gmail.mateuszmonas.androidtodomvp.utils.NetModule;

public class ToDoApplication extends Application {

    private DataRepositoryComponent dataRepositoryComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        dataRepositoryComponent = DaggerDataRepositoryComponent.builder()
                .netModule(new NetModule("placeholder", "placeholder", "https://localhost"))
                .dataSourceModule(new DataSourceModule())
                .build();
    }

    public DataRepositoryComponent getDataRepositoryComponent() {
        return dataRepositoryComponent;
    }

}
