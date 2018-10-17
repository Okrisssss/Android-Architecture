package com.example.mvp_dagger.di.components;


import com.example.mvp_dagger.di.modules.MainModule;
import com.example.mvp_dagger.di.scopes.ScopeMain;
import com.example.mvp_dagger.presenter.JokesPresenter;
import com.example.mvp_dagger.view.MainActivity;

import dagger.Component;

@ScopeMain
@Component(dependencies = {ApplicationComponent.class}, modules = {MainModule.class})
public interface MainComponent {
    void inject(MainActivity mainActivity);
}
