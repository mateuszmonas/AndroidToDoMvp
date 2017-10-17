package com.gmail.mateuszmonas.androidtodomvp.data;

import com.gmail.mateuszmonas.androidtodomvp.utils.DatabaseModule;
import com.gmail.mateuszmonas.androidtodomvp.utils.NetModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {DataSourceModule.class, NetModule.class, DatabaseModule.class})
public interface DataRepositoryComponent {

    DataRepository getDataRepository();

}
