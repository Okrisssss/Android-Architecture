package com.example.mvp_dagger.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mvp_dagger.R;
import com.example.mvp_dagger.di.Injector;
import com.example.mvp_dagger.presenter.JokesPresenter;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    JokesPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Injector.INSTANCE.initMainComponent(this);
    }
}
