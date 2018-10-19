package com.example.just_simple_mvvm.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.TextWatcher;

import com.example.just_simple_mvvm.BR;
import com.example.just_simple_mvvm.data.api.ApiClient;
import com.example.just_simple_mvvm.data.model.Joke;
import com.example.just_simple_mvvm.data.model.JokeResponse;
import com.example.just_simple_mvvm.utils.TextUtils;
import com.example.just_simple_mvvm.utils.TextWatcherAdapter;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JokeViewModel extends BaseObservable {

    public ObservableField<String> jokeText = new ObservableField<>();
    public ObservableField<String> txtRandomDigit = new ObservableField<>();
    public ObservableField<Integer> progressBar = new ObservableField<>();

    private ApiClient apiClient = new ApiClient();
    private int busy = 8;

    @Bindable
    public int getBusy() {
        return this.busy;
    }
    public void setBusy(int busy) {
        this.busy = busy;
        notifyPropertyChanged(BR.busy);
    }


    public TextWatcher randomDigitTextWatcher = new TextWatcherAdapter() {
        @Override
        public void afterTextChanged(Editable s) {
            if (!Objects.equals(txtRandomDigit.get(), s.toString())) {
                txtRandomDigit.set(s.toString());
            }
        }
    };

    public void showJoke() {
        txtRandomDigit.set(TextUtils.getRandomDigit());
        setBusy(0);
        apiClient
                .getClient()
                .getJoke(txtRandomDigit.get())
                .enqueue(new Callback<JokeResponse>() {
                    @Override
                    public void onResponse(@NonNull Call<JokeResponse> call, @NonNull Response<JokeResponse> response) {
                        JokeResponse data = response.body();

                        if (data != null && data.getJoke() != null) {
                            Joke joke = data.getJoke();
                            jokeText.set(joke.getJokeText());
                            setBusy(8);
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
