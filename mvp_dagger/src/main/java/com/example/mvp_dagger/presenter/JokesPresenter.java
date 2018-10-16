package com.example.mvp_dagger.presenter;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.mvp_dagger.model.Joke;
import com.example.mvp_dagger.model.JokeResponse;
import com.example.mvp_dagger.view.JokeView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JokesPresenter {

    private JokeView jokeView;

    public JokesPresenter(JokeView jokeView) {
        this.jokeView = jokeView;
    }

    public void showJoke(String jokeId) {
        jokeView.getJokes(jokeId)
                .enqueue(new Callback<JokeResponse>() {
                    @Override
                    public void onResponse(@NonNull Call<JokeResponse> call, @NonNull Response<JokeResponse> response) {
                        JokeResponse data = response.body();

                        if (data != null && data.getJoke() != null) {
                            List<Joke> joke = data.getJoke();
                            jokeView.onJokeReceived(joke);
                            Log.d("SimpleLog", joke.get(0).getJoke());
                        } else {
                            jokeView.onError("Something went wrong!");
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<JokeResponse> call, @NonNull Throwable t) {
                        call.cancel();
                        jokeView.onError(t.getMessage());
                        Log.d("SimpleLog", t.getMessage());
                    }
                });
    }

}
