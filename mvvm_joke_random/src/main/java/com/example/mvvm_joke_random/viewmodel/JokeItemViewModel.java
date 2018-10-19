package com.example.mvvm_joke_random.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.text.TextUtils;

import com.example.mvvm_joke_random.data.model.Joke;

public class JokeItemViewModel extends BaseObservable {
    private Joke joke;

    public JokeItemViewModel(Joke joke) {
        this.joke = joke;
    }
    public void setUp() {
        // perform set up tasks, such as adding listeners
    }

    public void tearDown() {
        // perform tear down tasks, such as removing listeners
    }

    @Bindable
    public String getJoke() {
        return !TextUtils.isEmpty(joke.getJoke()) ? joke.getJoke() : "";
    }
}
