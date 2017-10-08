package com.gmail.mateuszmonas.androidtodomvp.data.objects;

public class Task {
    private int globalId;
    private int localId;
    private String description;
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

    public Task(int localId, String description) {
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

    public int getLocalId() {
        return localId;
    }

    public void setLocalId(int localId) {
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
