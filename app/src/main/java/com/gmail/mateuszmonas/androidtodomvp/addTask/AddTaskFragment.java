package com.gmail.mateuszmonas.androidtodomvp.addTask;


import android.support.v4.app.Fragment;

public class AddTaskFragment extends Fragment implements AddTaskContract.View {

    private AddTaskContract.Presenter presenter;

    public static AddTaskFragment newInstance(){
        return new AddTaskFragment();
    }

    public AddTaskFragment(){}

    @Override
    public void setPresenter(AddTaskContract.Presenter presenter) {
        this.presenter=presenter;
    }
}
