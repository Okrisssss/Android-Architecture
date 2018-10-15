package com.example.mvp_dagger.di.components;

import android.content.Context;

import com.example.mvp_dagger.api.ApiInterface;
import com.example.mvp_dagger.di.modules.ApplicationModule;
import com.example.mvp_dagger.di.modules.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

@Singleton
@Component(modules = {ApplicationModule.class, NetworkModule.class})
public interface ApplicationComponent {
    Context context();

    ApiInterface apiInterface();

//    Retrofit retrofit();
}
