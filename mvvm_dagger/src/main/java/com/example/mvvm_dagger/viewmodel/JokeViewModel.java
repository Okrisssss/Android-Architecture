package com.example.mvvm_dagger.viewmodel;


import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.TextWatcher;

import com.example.mvvm_dagger.model.Joke;
import com.example.mvvm_dagger.model.JokeResponse;
import com.example.mvvm_dagger.repository.network.ApiInterface;
import com.example.mvvm_dagger.utils.TextUtils;
import com.example.mvvm_dagger.utils.TextWatcherAdapter;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JokeViewModel extends BaseObservable {

    public ObservableField<String> jokeText = new ObservableField<>();
    public ObservableField<String> txtRandomDigit = new ObservableField<>();

    ApiInterface apiInterface;
    private int progressBar = 8;

    @Bindable
    public int getProgressBar() {
        return this.progressBar;
    }
    public void setProgressBar(int progressBar) {
        this.progressBar = progressBar;
       notifyPropertyChanged(com.example.mvvm_dagger.viewmodel.);
    }


    public JokeViewModel(ApiInterface apiInterface) {
        this.apiInterface = apiInterface;
    }

    public TextWatcher randomDigitTextWatcher = new TextWatcherAdapter() {
        @Override
        public void afterTextChanged(Editable s) {
            if (!Objects.equals(txtRandomDigit.get(), s.toString())) {
                txtRandomDigit.set(s.toString());
            }
        }
    };

    public JokeViewModel() {
    }
//    @Bindable
//    public int getBusy(){
//        return this.busy;
//    }
//
//    public void setBusy(){
//        this.busy = busy;
//        notifyPropertyChanged(busy);
//    }

    public void showJoke() {
        txtRandomDigit.set(TextUtils.getRandomDigit());
        //setBusy(0);
        apiInterface
                .getJoke(txtRandomDigit.get())
                .enqueue(new Callback<JokeResponse>() {
                    @Override
                    public void onResponse(@NonNull Call<JokeResponse> call, @NonNull Response<JokeResponse> response) {
                        JokeResponse data = response.body();

                        if (data != null && data.getJoke() != null) {
                            Joke joke = data.getJoke();
                            jokeText.set(joke.getJokeText());
//                           setBusy(8);
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
