package apple.example.com.mvp_random_jokes.ui.jokes;

import java.util.List;

import apple.example.com.mvp_random_jokes.data.model.Joke;

public interface JokeView {

    void onJokeReceived(List<Joke> joke);

    void onError(String message);
}
