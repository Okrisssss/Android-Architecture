package com.example.mvvm_dagger;

import android.app.Application;

import com.example.mvvm_dagger.di.Injector;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Injector.INSTANCE.initApplicationComponent(this);
    }


    @Override
    public void onTerminate() {
        super.onTerminate();
        Injector.INSTANCE.releaseApplicationComponent();
    }
}
