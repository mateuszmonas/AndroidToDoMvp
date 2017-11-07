package com.gmail.mateuszmonas.androidtodomvp.data.local;


import com.gmail.mateuszmonas.androidtodomvp.data.DataSource;
import com.gmail.mateuszmonas.androidtodomvp.data.objects.Task;

import java.util.List;
import java.util.concurrent.Callable;

import javax.inject.Inject;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class LocalDataSource implements DataSource {

    private final TasksDatabase tasksDatabase;

    @Inject
    public LocalDataSource(TasksDatabase tasksDatabase) {
        this.tasksDatabase = tasksDatabase;
    }

    @Override
    public void getTasks(SingleObserver<List<Task>> observer, int offset) {
        tasksDatabase.taskDao().getTasks()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    @Override
    public void editTask(MaybeObserver<Task> observer, final Task task) {
        Maybe.fromCallable(new Callable<Task>() {
            @Override
            public Task call() throws Exception {
                tasksDatabase.taskDao().updateTask(task);
                return task;
            }
        }).subscribeOn(Schedulers.newThread())
                .subscribe(observer);
    }

    //first we get task to be updated from database
    //then we change task to done
    //then we update database by supplying the task
    //then we return updated task
    @Override
    public void setTaskDone(final MaybeObserver<Task> observer, long localId) {
        MaybeObserver<Task> maybeObserver = new MaybeObserver<Task>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onSuccess(Task task) {
                task.setDone(!task.isDone());
                tasksDatabase.taskDao().updateTask(task);
                Maybe.just(task)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(observer);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
            }
        };
        tasksDatabase.taskDao().getTask(localId)
                .subscribeOn(Schedulers.newThread())
                .subscribe(maybeObserver);
    }

    @Override
    public void addTask(final SingleObserver<Long> observer, Task task) {
        Single.just(task).subscribeOn(Schedulers.newThread())
                .subscribe(new SingleObserver<Task>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        observer.onSubscribe(d);
                    }

                    @Override
                    public void onSuccess(@NonNull Task task) {
                        tasksDatabase.taskDao().addTask(task);
                        observer.onSuccess(task.getLocalId());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        observer.onError(e);
                    }
                });
    }

    @Override
    public void deleteTasks(final SingleObserver<List<Task>> observer) {
        tasksDatabase.taskDao().getDoneTasks()
                .subscribeOn(Schedulers.newThread())
                .subscribe(new SingleObserver<List<Task>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onSuccess(List<Task> tasks) {
                        tasksDatabase.taskDao().deleteTask(tasks);
                        tasksDatabase.taskDao().getTasks()
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(observer);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

    @Override
    public void getTask(MaybeObserver<Task> observer, long localId) {
        tasksDatabase.taskDao().getTask(localId)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
