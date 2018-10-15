package com.example.mvp_dagger.presenter;

import android.content.Context;
import com.example.mvp_dagger.api.ApiInterface;

public class JokesPresenter {

    private Context context;
    private ApiInterface apiInterface;

    public JokesPresenter() {
    }

    public JokesPresenter(Context context, ApiInterface weatherRestApi) {
        this.context = context;
        this.apiInterface = weatherRestApi;
    }
}
