package com.gmail.mateuszmonas.androidtodomvp.data.objects;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Task {
    private int globalId;
    @PrimaryKey(autoGenerate = true)
    private long localId;
    @ColumnInfo(name = "description")
    private String description;
    @ColumnInfo(name = "done")
    private boolean done;

    public Task(int localId, String description, boolean done) {
        this.localId = localId;
        this.description = description;
        this.done = done;
    }

    public Task(String description, boolean done) {
        this.description = description;
        this.done = done;
    }

    Task(String description) {
        this.description = description;
        this.done =false;
    }

    public Task(long localId, String description) {
        this.localId = localId;
        this.description = description;
        this.done =false;
    }

    Task(){
        localId =0;
        description ="";
        done =false;
    }

    public int getGlobalId() {
        return globalId;
    }

    void setGlobalId(int globalId) {
        this.globalId = globalId;
    }

    public long getLocalId() {
        return localId;
    }

    public void setLocalId(long localId) {
        this.localId = localId;
    }

    public String getDescription() {
        return description;
    }

    void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean _isDone) {
        this.done = _isDone;
    }

}
