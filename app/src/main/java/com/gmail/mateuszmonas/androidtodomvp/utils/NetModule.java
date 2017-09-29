package com.gmail.mateuszmonas.androidtodomvp.utils;

import android.util.Base64;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;

@Module
public class NetModule {

    private String login;
    private String password;
    private String address;

    public NetModule(String login, String password, String address) {
        this.login = login;
        this.password = password;
        this.address = address;
    }

    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder().create();
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {
        Interceptor authInterceprot = new AuthenticationInterceptor(login, password);
        return new OkHttpClient.Builder().addInterceptor(authInterceprot).build();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(Gson gson, OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(address)
                .client(okHttpClient)
                .build();
    }
}

//added to okhttp as basic authentication header
class AuthenticationInterceptor implements Interceptor {

    private final String authToken;

    AuthenticationInterceptor(String username, String password) {
        String pass = username + ":" + password;
        this.authToken = "Basic " + Base64.encodeToString(pass.getBytes(), Base64.NO_WRAP);
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();

        Request.Builder builder = original.newBuilder()
                .header("Authorization", authToken);

        Request request = builder.build();
        return chain.proceed(request);
    }
}