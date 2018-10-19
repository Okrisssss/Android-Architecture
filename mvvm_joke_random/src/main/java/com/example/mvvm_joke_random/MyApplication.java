package com.example.mvvm_joke_random;

import android.app.Application;
import android.databinding.DataBindingUtil;

import com.example.mvvm_joke_random.databinding.AppDataBindingComponent;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        DataBindingUtil.setDefaultComponent(new AppDataBindingComponent());
    }
}
