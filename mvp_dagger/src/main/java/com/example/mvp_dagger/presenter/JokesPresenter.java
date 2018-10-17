package com.example.mvp_dagger.presenter;

import android.annotation.SuppressLint;
import android.util.Log;

import com.example.mvp_dagger.di.Injector;
import com.example.mvp_dagger.model.Joke;
import com.example.mvp_dagger.repository.network.ApiInterface;
import com.example.mvp_dagger.view.JokeView;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class JokesPresenter {
    ApiInterface apiInterface;
    private JokeView jokeView;

    public JokesPresenter(JokeView jokeView, ApiInterface apiInterface) {
        this.jokeView = jokeView;
        this.apiInterface = apiInterface;
    }

    @SuppressLint("CheckResult")
    public void showJoke(String jokeId) {
        //subscribeOn - working thread for long time operation
        //observeOn - thread to display result
        apiInterface.getRandomJokes(jokeId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(jokeResponse -> {
                    if (jokeResponse != null && jokeResponse.getJoke() != null) {
                        List<Joke> joke = jokeResponse.getJoke();
                        jokeView.onJokeReceived(joke);
                    }
                }, throwable -> {
                    jokeView.onError("Something went wrong! throwable is " + throwable.getMessage());
                });
    }

}
