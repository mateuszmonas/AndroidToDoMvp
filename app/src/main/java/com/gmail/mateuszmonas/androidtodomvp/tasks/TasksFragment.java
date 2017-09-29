package com.gmail.mateuszmonas.androidtodomvp.tasks;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gmail.mateuszmonas.androidtodomvp.R;

public class TasksFragment extends Fragment implements TasksContract.View {

    private TasksContract.Presenter presenter;

    public TasksFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tasks, container, false);
        return view;
    }

    @Override
    public void setPresenter(TasksContract.Presenter presenter) {
        this.presenter=presenter;
    }

    public static TasksFragment newInstance(){
        return new TasksFragment();
    }

}
