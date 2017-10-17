package com.gmail.mateuszmonas.androidtodomvp.utils;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.gmail.mateuszmonas.androidtodomvp.data.local.TasksDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DatabaseModule {

    private final Context context;
    private final String databaseName;

    public DatabaseModule(Context context, String databaseName) {
        this.context = context;
        this.databaseName = databaseName;
    }

    @Provides
    @Singleton
    TasksDatabase provideTaskDatabase(){
        return Room.databaseBuilder(context, TasksDatabase.class, databaseName).build();
    }

}
