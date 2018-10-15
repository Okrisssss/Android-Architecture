package com.example.mvvm_random_jokes.viewmodel;

import android.databinding.ObservableField;
import android.text.Editable;
import android.text.TextWatcher;

import com.example.mvvm_random_jokes.utils.TextWatcherAdapter;

import java.util.Objects;

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
}
