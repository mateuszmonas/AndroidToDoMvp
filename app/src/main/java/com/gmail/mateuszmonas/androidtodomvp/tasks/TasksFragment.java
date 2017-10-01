package com.gmail.mateuszmonas.androidtodomvp.tasks;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gmail.mateuszmonas.androidtodomvp.R;
import com.gmail.mateuszmonas.androidtodomvp.data.objects.Task;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class TasksFragment extends Fragment implements TasksContract.View {

    private Unbinder unbinder;
    private TasksContract.Presenter presenter;
    private TasksAdapter adapter;
    @BindView(R.id.tasksRecyclerView)
    RecyclerView taskRecyclerView;
    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;
    private final TasksListListener listener = new TasksListListener() {

    };

    public static TasksFragment newInstance(){
        return new TasksFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new TasksAdapter(new ArrayList<Task>(), listener);

    }

    public TasksFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tasks, container, false);
        unbinder = ButterKnife.bind(this, view);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        taskRecyclerView.setLayoutManager(layoutManager);
        taskRecyclerView.setAdapter(adapter);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(false);
            }
        });
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.loadTasks(0, true);
            }
        });
        return view;
    }

    @Override
    public void setPresenter(TasksContract.Presenter presenter) {
        this.presenter=presenter;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.start();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void showTasks(List<Task> tasks, boolean forceUpdate) {
        adapter.replaceData(tasks, forceUpdate);
    }

    @Override
    public void setRefreshingView(boolean refreshing) {
        swipeRefreshLayout.setRefreshing(refreshing);
    }

    interface TasksListListener{
    }
}
