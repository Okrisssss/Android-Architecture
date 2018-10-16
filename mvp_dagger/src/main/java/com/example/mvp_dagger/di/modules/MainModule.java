package com.example.mvp_dagger.di.modules;

import com.example.mvp_dagger.di.scopes.ScopeMain;
import com.example.mvp_dagger.presenter.JokesPresenter;
import com.example.mvp_dagger.view.JokeView;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {

    private JokeView jokeView;

    public MainModule(JokeView jokeView) {
        this.jokeView = jokeView;
    }

    @Provides
    @ScopeMain
    public JokesPresenter providePresenter() {
        return new JokesPresenter(jokeView);
    }
}
