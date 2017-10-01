package com.gmail.mateuszmonas.androidtodomvp.data;

import com.gmail.mateuszmonas.androidtodomvp.data.local.LocalDataSourceModule;
import com.gmail.mateuszmonas.androidtodomvp.data.remote.RemoteDataSourceModule;
import com.gmail.mateuszmonas.androidtodomvp.utils.NetModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {RemoteDataSourceModule.class, LocalDataSourceModule.class, NetModule.class})
public interface DataRepositoryComponent {

    DataRepository getDataRepository();

}
