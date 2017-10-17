package com.gmail.mateuszmonas.androidtodomvp.data.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.gmail.mateuszmonas.androidtodomvp.data.objects.Task;
import com.gmail.mateuszmonas.androidtodomvp.data.objects.TaskDao;

@Database(entities = Task.class, version = 1)
public abstract class TasksDatabase extends RoomDatabase{

    public abstract TaskDao taskDao();

}
