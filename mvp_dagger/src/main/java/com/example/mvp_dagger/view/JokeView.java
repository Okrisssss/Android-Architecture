package com.example.mvp_dagger.view;

import com.example.mvp_dagger.model.Joke;
import com.example.mvp_dagger.model.JokeResponse;

import java.util.List;

import retrofit2.Call;

public interface JokeView {

    void onJokeReceived(List<Joke> joke);

    void onError(String message);

    Call<JokeResponse> getJokes(String jokeNumber);
}