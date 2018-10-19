package com.example.mvvm_dagger.repository.network;

import com.example.mvvm_dagger.model.JokeResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {
    @GET("/jokes/{jokeId}")
    Call<JokeResponse> getJoke(@Path("jokeId") String jokeId);
}
