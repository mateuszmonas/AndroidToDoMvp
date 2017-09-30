package com.gmail.mateuszmonas.androidtodomvp.tasks;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.gmail.mateuszmonas.androidtodomvp.data.objects.Task;

import java.util.List;

public class TasksAdapter extends RecyclerView.Adapter<TasksAdapter.ViewHolder> {

    private final List<Task> tasks;
    private final TasksFragment.TasksListListener listener;

    TasksAdapter(List<Task> tasks, TasksFragment.TasksListListener listener) {
        this.tasks = tasks;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

}
