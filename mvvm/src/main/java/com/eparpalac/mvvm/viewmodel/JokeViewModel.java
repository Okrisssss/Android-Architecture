package com.eparpalac.mvvm.viewmodel;

import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.TextWatcher;

import com.eparpalac.mvvm.data.api.ApiClient;
import com.eparpalac.mvvm.data.model.Joke;
import com.eparpalac.mvvm.data.model.JokeResponse;
import com.eparpalac.mvvm.utils.TextWatcherAdapter;

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

    public void onShowData() {
        apiClient
                .getClient()
                .getJoke(jokeId.get())
                .enqueue(new Callback<JokeResponse>() {
                    @Override
                    public void onResponse(@NonNull Call<JokeResponse> call, @NonNull Response<JokeResponse> response) {
                        JokeResponse data = response.body();

                        if (data != null && data.getJoke() != null) {
                            Joke joke = data.getJoke();
                            jokeText.set(joke.getJokeText());
                        } else {
                            jokeText.set("Something went wrong!");
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<JokeResponse> call, @NonNull Throwable t) {
                        call.cancel();
                        jokeText.set(t.getMessage());
                    }
                });
    }
}
