package com.gmail.mateuszmonas.androidtodomvp.data;

import com.gmail.mateuszmonas.androidtodomvp.data.local.Local;
import com.gmail.mateuszmonas.androidtodomvp.data.local.LocalDataSource;
import com.gmail.mateuszmonas.androidtodomvp.data.remote.Remote;
import com.gmail.mateuszmonas.androidtodomvp.data.remote.RemoteDataSource;
import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@Module
public class DataSourceModule {

    @Singleton
    @Provides
    @Remote
    DataSource provideRemoteDataSource(Retrofit retrofit, Gson gson, OkHttpClient okHttpClient) {
        return new RemoteDataSource(retrofit, gson, okHttpClient);
    }

    @Singleton
    @Provides
    @Local
    DataSource provideLocalDataSource() {
        return new LocalDataSource();
    }

}
