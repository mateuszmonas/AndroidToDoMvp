package com.gmail.mateuszmonas.androidtodomvp.data;


import com.gmail.mateuszmonas.androidtodomvp.data.remote.Remote;

import javax.inject.Inject;

public class DataRepository implements DataSource {

    private DataSource remoteDataSource;

    @Inject
    public DataRepository(@Remote DataSource remoteDataSource) {
        this.remoteDataSource = remoteDataSource;
    }

}
