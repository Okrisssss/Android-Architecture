package com.example.mvvm_dagger.di.components;

import com.example.mvvm_dagger.di.modules.MainModule;
import com.example.mvvm_dagger.di.scopes.ScopeMain;
import com.example.mvvm_dagger.view.MainActivity;

import dagger.Component;

@ScopeMain
@Component(dependencies = {ApplicationComponent.class}, modules = {MainModule.class})
public interface MainComponent {
    void inject(MainActivity mainActivity);
}
