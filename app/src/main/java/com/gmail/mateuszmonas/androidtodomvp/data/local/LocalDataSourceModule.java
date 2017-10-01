package com.gmail.mateuszmonas.androidtodomvp.data.local;

import com.gmail.mateuszmonas.androidtodomvp.data.DataSource;
import com.gmail.mateuszmonas.androidtodomvp.data.remote.Remote;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class LocalDataSourceModule {

    @Singleton
    @Provides
    @Local
    DataSource provideLocalDataSource() {
        return new LocalDataSource();
    }

}
