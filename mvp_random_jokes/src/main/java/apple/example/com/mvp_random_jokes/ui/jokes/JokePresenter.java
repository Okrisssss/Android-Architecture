package apple.example.com.mvp_random_jokes.ui.jokes;

import android.renderscript.Sampler;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import apple.example.com.mvp_random_jokes.data.api.ApiClient;
import apple.example.com.mvp_random_jokes.data.api.ApiInterface;
import apple.example.com.mvp_random_jokes.data.model.Joke;
import apple.example.com.mvp_random_jokes.data.model.JokeResponse;
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
                .getRandomJokes(jokeId)
                .enqueue(new Callback<JokeResponse>() {
                    @Override
                    public void onResponse(@NonNull Call<JokeResponse> call, @NonNull Response<JokeResponse> response) {
                        JokeResponse data = response.body();

                        if (data != null && data.getJoke() != null) {
                            List<Joke> joke = data.getJoke();
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
    }
}
