package com.example.mvp_dagger.repository.network;

import com.example.mvp_dagger.model.JokeResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {
    @GET("/jokes/random/{randomDigit}")
    Call<JokeResponse> getRandomJokes(@Path("randomDigit") String randomDigit);
}