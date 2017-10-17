package com.gmail.mateuszmonas.androidtodomvp.data;


import com.gmail.mateuszmonas.androidtodomvp.data.local.Local;
import com.gmail.mateuszmonas.androidtodomvp.data.objects.Task;
import com.gmail.mateuszmonas.androidtodomvp.data.remote.Remote;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import javax.inject.Inject;
import javax.inject.Singleton;

//test implementation
// TODO: 10/8/17
@Singleton
public class DataRepository implements DataSource {

    private DataSource remoteDataSource;
    private DataSource localDataSource;
    //dummy data
    private final ArrayList<Task> tasks = new ArrayList<>(
            Arrays.asList(
                    new Task(1, "asdasd", false),
                    new Task(2, "asdasd", false),
                    new Task(3, "asdasd", false),
                    new Task(4, "asdasd", false),
                    new Task(5, "asdasd", false),
                    new Task(6, "asdasd", false),
                    new Task(7, "asdasd", false),
                    new Task(8, "asdasd", false),
                    new Task(9, "asdasd", false))
    );

    @Inject
    DataRepository(@Remote DataSource remoteDataSource, @Local DataSource localDataSource) {
        this.remoteDataSource = remoteDataSource;
        this.localDataSource = localDataSource;
    }

    @Override
    public void getTasks(final CallbackServerResponse<ArrayList<Task>> callback, int offset) {
        localDataSource.getTasks(new CallbackServerResponse<ArrayList<Task>>() {
            @Override
            public void onResponse(ArrayList<Task> response) {
                callback.onResponse(response);
            }

            @Override
            public void onFailure() {

            }
        }, offset);
    }

    @Override
    public void editTask(CallbackServerResponse<Task> callback, Task task) {
        int index = 0;
        for(Task t : tasks){
            if(t.getLocalId()==task.getLocalId()){
                index = tasks.indexOf(t);
                task.setDone(t.isDone());
                tasks.set(index, task);
                break;
            }
        }
        callback.onResponse(tasks.get(index));
    }

    @Override
    public void setTaskDone(CallbackServerResponse<Task> callback, int localId) {
        Task task = null;
        for(Task t : tasks){
            if(t.getLocalId()==localId){
                t.setDone(!t.isDone());
                task=t;
                break;
            }
        }
        callback.onResponse(task);
    }

    @Override
    public void addTask(CallbackServerResponse<Task> callback, Task task) {
        task.setLocalId(tasks.size()+1);
        tasks.add(task);
        callback.onResponse(task);
    }

    @Override
    public void deleteTasks(CallbackServerResponse<ArrayList<Task>> callback) {
        for(Iterator<Task> it = tasks.iterator(); it.hasNext();){
            if(it.next().isDone()){
                it.remove();
            }
        }
        callback.onResponse(tasks);
    }
}
