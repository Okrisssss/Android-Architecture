package com.example.mvvm_dagger.di.components;

import android.content.Context;

import com.example.mvvm_dagger.di.modules.ApplicationModule;
import com.example.mvvm_dagger.di.modules.NetworkModule;
import com.example.mvvm_dagger.repository.network.ApiInterface;

import javax.inject.Singleton;

        import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, NetworkModule.class})
public interface ApplicationComponent {

    Context context();

    ApiInterface apiInterface();
}
