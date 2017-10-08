package com.gmail.mateuszmonas.androidtodomvp.addTask;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gmail.mateuszmonas.androidtodomvp.R;
import com.gmail.mateuszmonas.androidtodomvp.data.objects.Task;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public class AddTaskFragment extends Fragment implements AddTaskContract.View {

    private AddTaskContract.Presenter presenter;
    private Unbinder unbinder;

    public static AddTaskFragment newInstance(){
        return new AddTaskFragment();
    }

    public AddTaskFragment(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_task, container, false);
        unbinder = ButterKnife.bind(this, view);

        ((AddTaskActivity) getActivity()).setConfirmNewTaskListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.addTask(new Task("dsaasd", false));
            }
        });

        return view;
    }

    @Override
    public void setPresenter(AddTaskContract.Presenter presenter) {
        this.presenter=presenter;
    }
}
