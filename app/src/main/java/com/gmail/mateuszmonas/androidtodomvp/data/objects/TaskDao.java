package com.gmail.mateuszmonas.androidtodomvp.data.objects;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Maybe;
import io.reactivex.Single;

@Dao
public interface TaskDao {

    @Query("SELECT * FROM task")
    Single<List<Task>> getTasks();

    @Query("SELECT * FROM task where task.localId=:localId")
    Maybe<Task> getTask(long localId);

    @Query("SELECT * FROM task WHERE task.done=1")
    Single<List<Task>> getDoneTasks();

    @Update
    void updateTask(Task task);

    @Delete
    void deleteTask(List<Task> tasks);

    @Insert
    long addTask(Task task);


}
