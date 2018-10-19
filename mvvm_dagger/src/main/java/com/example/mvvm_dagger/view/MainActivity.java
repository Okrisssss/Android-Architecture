package com.example.mvvm_dagger.view;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mvvm_dagger.R;
import com.example.mvvm_dagger.databinding.ActivityMainBinding;
import com.example.mvvm_dagger.di.Injector;
import com.example.mvvm_dagger.repository.network.ApiInterface;
import com.example.mvvm_dagger.viewmodel.JokeViewModel;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    @Inject JokeViewModel jokeViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Injector.INSTANCE.initMainComponent(this);

        ActivityMainBinding bindding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        bindding.setViewModel(jokeViewModel);
    }
    }

