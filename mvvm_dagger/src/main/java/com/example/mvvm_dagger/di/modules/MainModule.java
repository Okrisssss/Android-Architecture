package com.example.mvvm_dagger.di.modules;


import com.example.mvvm_dagger.di.scopes.ScopeMain;
import com.example.mvvm_dagger.repository.network.ApiInterface;
import com.example.mvvm_dagger.view.MainActivity;
import com.example.mvvm_dagger.viewmodel.JokeViewModel;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {

    public MainModule(MainActivity mainActivity) {
    }

    @Provides
    @ScopeMain
    public JokeViewModel provideViewModel(ApiInterface apiInterface) {
        return new JokeViewModel(apiInterface);
    }
}