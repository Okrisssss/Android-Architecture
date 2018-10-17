package com.example.mvp_dagger.repository.network;

import com.example.mvp_dagger.model.JokeResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {
    @GET("/jokes/random/{randomDigit}")
    Single<JokeResponse> getRandomJokes(@Path("randomDigit") String randomDigit);

    @GET("/jokes/{numberOfJoke}")
    Single<JokeResponse> getJokeById(@Path("numberOfJoke") String numberOfJoke);
}