package com.gmail.mateuszmonas.androidtodomvp.data.objects;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface TaskDao {

    @Query("SELECT * FROM task")
    List<Task> getAll();

}
