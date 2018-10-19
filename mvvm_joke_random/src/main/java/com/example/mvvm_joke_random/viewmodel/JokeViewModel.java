package com.example.mvvm_joke_random.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.annotation.NonNull;

import com.example.mvvm_joke_random.BR;
import com.example.mvvm_joke_random.data.api.ApiClient;
import com.example.mvvm_joke_random.data.model.Joke;
import com.example.mvvm_joke_random.data.model.JokeResponse;
import com.example.mvvm_joke_random.utils.TextUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JokeViewModel extends BaseObservable {

    private static final String TAG = "DataViewModel";
    JokesAdapter jokesAdapter;
    private List<Joke> jokes;
    TextUtils textUtils;
    ApiClient apiClient;

    public JokeViewModel(JokesAdapter jokesAdapter, List<Joke> jokes) {
        this.jokesAdapter = jokesAdapter;
        this.jokes = jokes;
    }

    public void setUp() {
        pupulateJoke(textUtils.getRandomDigit());
    }

    public void tearDown() {
    }

    @Bindable
    public List<Joke> getJokes() {
        return this.jokes;
    }

    @Bindable
    public JokesAdapter getAdapter() {
        return this.jokesAdapter;
    }

    public void pupulateJoke(String jokeId) {
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
                        notifyPropertyChanged(BR.jokes);
                    }

                    @Override
                    public void onFailure(@NonNull Call<JokeResponse> call, @NonNull Throwable t) {
                        call.cancel();
                    }
                });
    }
}
