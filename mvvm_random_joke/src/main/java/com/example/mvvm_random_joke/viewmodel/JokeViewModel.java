package com.example.mvvm_random_joke.viewmodel;

import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.TextWatcher;

import com.example.mvvm_random_joke.data.api.ApiClient;
import com.example.mvvm_random_joke.data.model.Joke;
import com.example.mvvm_random_joke.data.model.JokeResponse;
import com.example.mvvm_random_joke.utils.TextWatcherAdapter;

import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JokeViewModel {
    public ObservableField<String> jokeId = new ObservableField<>();
    public ObservableField<String> jokeText = new ObservableField<>();
    public TextWatcher jokeIdWatcher = new TextWatcherAdapter() {
        @Override
        public void afterTextChanged(Editable s) {
            if (!Objects.equals(jokeId.get(), s.toString())) {
                jokeId.set(s.toString());
            }
        }
    };
    private ApiClient apiClient = new ApiClient();

    public void showJoke(String jokeId) {
        apiClient
                .getClient()
                .getRandomJokes(jokeId)
                .enqueue(new Callback<JokeResponse>() {
                    @Override
                    public void onResponse(@NonNull Call<JokeResponse> call, @NonNull Response<JokeResponse> response) {
                        JokeResponse data = response.body();

                        if (data != null && data.getJoke() != null) {
                            List<Joke> joke = data.getJoke();
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<JokeResponse> call, @NonNull Throwable t) {
                        call.cancel();
                    }
                });
    }
}
