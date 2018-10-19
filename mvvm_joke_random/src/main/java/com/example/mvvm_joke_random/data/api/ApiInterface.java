package com.example.mvvm_joke_random.data.api;

import com.example.mvvm_joke_random.data.model.JokeResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {
    @GET("/jokes/random/{randomDigit}")
    Call<JokeResponse> getRandomJokes(@Path("randomDigit") String randomDigit);
}
