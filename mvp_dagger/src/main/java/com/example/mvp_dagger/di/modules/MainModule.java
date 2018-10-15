package com.example.mvp_dagger.di.modules;

import android.content.Context;

import com.example.mvp_dagger.api.ApiInterface;
import com.example.mvp_dagger.di.scopes.ScopeMain;
import com.example.mvp_dagger.presenter.JokesPresenter;
import com.example.mvp_dagger.view.MainActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {

    private MainActivity mainActivity;

    public MainModule(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Provides
    @ScopeMain
    public JokesPresenter providePresenter(Context context, ApiInterface apiInterface) {
        return new JokesPresenter(context, apiInterface);
    }
}
