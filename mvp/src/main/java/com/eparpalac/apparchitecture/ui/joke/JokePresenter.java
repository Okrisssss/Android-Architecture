package com.eparpalac.apparchitecture.ui.joke;

import android.support.annotation.NonNull;

import com.eparpalac.apparchitecture.data.api.ApiClient;
import com.eparpalac.apparchitecture.data.model.Joke;
import com.eparpalac.apparchitecture.data.model.JokeResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JokePresenter {

    private JokeView jokeView;
    private ApiClient apiClient;

    JokePresenter(JokeView view) {
        this.jokeView = view;

        if (this.apiClient == null) {
            this.apiClient = new ApiClient();
        }
    }

    public void showJoke(String jokeId) {
        apiClient
                .getClient()
                .getJoke(jokeId)
                .enqueue(new Callback<JokeResponse>() {
                    @Override
                    public void onResponse(@NonNull Call<JokeResponse> call, @NonNull Response<JokeResponse> response) {
                        JokeResponse data = response.body();

                        if (data != null && data.getJoke() != null) {
                            Joke joke = data.getJoke();
                            jokeView.onJokeReceived(joke);
                        } else {
                            jokeView.onError("Something went wrong!");
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<JokeResponse> call, @NonNull Throwable t) {
                        call.cancel();
                        jokeView.onError(t.getMessage());
                    }
                });
        return;
    }
}
