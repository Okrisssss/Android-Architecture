package apple.example.com.mvp_random_jokes.data.api;

import apple.example.com.mvp_random_jokes.data.model.JokeResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {
    @GET("/jokes/random/{randomDigit}")
    Call<JokeResponse> getRandomJokes(@Path("randomDigit") String randomDigit);
}
