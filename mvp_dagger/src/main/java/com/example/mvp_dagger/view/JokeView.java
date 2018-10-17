package com.example.mvp_dagger.view;

import com.example.mvp_dagger.model.Joke;

import java.util.List;


public interface JokeView {

    void onJokeReceived(List<Joke> joke);

    void onError(String message);
}