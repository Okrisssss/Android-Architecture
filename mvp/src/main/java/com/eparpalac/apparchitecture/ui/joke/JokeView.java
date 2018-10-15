package com.eparpalac.apparchitecture.ui.joke;

import com.eparpalac.apparchitecture.data.model.Joke;

public interface JokeView {
    void onJokeReceived(Joke joke);

    void onError(String message);
}
