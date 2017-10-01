package com.gmail.mateuszmonas.androidtodomvp.data.remote;

import com.gmail.mateuszmonas.androidtodomvp.data.DataSource;
import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@Module
public class RemoteDataSourceModule {

    @Singleton
    @Provides
    @Remote
    DataSource provideRemoteDataSource(Retrofit retrofit, Gson gson, OkHttpClient okHttpClient) {
        return new RemoteDataSource(retrofit, gson, okHttpClient);
    }

}
