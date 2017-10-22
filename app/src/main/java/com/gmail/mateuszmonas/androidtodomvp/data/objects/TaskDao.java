package com.gmail.mateuszmonas.androidtodomvp.data.objects;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Maybe;
import io.reactivex.Single;

@Dao
public interface TaskDao {

    @Query("SELECT * FROM task")
    Single<List<Task>> getTasks();

    @Query("SELECT * FROM task where task.localId=:localId")
    Maybe<Task> getTask(int localId);


    @Insert
    long addTask(Task task);


}
