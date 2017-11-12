package com.gmail.mateuszmonas.androidtodomvp.addTask;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gmail.mateuszmonas.androidtodomvp.R;
import com.gmail.mateuszmonas.androidtodomvp.data.objects.Task;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class AddTaskFragment extends Fragment implements AddTaskContract.View {

    private AddTaskContract.Presenter presenter;
    private static final String EXTRA_LOCAL_ID = "LOCAL_ID";
    private Unbinder unbinder;
    private Long localId = null;
    @BindView(R.id.taskDescription)
    TextView taskDescription;

    public static AddTaskFragment newInstance(Long localId){
        AddTaskFragment fragment = new AddTaskFragment();
        Bundle arguments = new Bundle();
        arguments.putLong(EXTRA_LOCAL_ID, localId);
        fragment.setArguments(arguments);
        return fragment;
    }

    public static AddTaskFragment newInstance(){
        return new AddTaskFragment();
    }

    public AddTaskFragment(){}

    @Override
    public void onDestroy() {
        unbinder.unbind();
        super.onDestroy();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_task, container, false);
        unbinder = ButterKnife.bind(this, view);

        Bundle arguments=getArguments();
        if(arguments!=null){
            if (arguments.containsKey(EXTRA_LOCAL_ID)){
                localId=arguments.getLong(EXTRA_LOCAL_ID);
                presenter.getTask(localId);
            }
        }

        ((AddTaskActivity) getActivity()).setConfirmNewTaskListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!taskDescription.getText().toString().isEmpty()) {
                    String description = taskDescription.getText().toString().trim();
                    if(localId==null){
                        presenter.addTask(new Task(description, false));
                    }else {
                        presenter.editTask(new Task(localId, description));
                    }
                }
            }
        });

        return view;
    }

    @Override
    public void setDescription(String description) {
        taskDescription.setText(description);
    }

    @Override
    public void finishActivity() {
        getActivity().finish();
    }

    @Override
    public void setPresenter(AddTaskContract.Presenter presenter) {
        this.presenter=presenter;
    }
}
