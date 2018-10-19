package com.example.just_simple_mvvm.view;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.just_simple_mvvm.R;
import com.example.just_simple_mvvm.databinding.ActivityMainBinding;
import com.example.just_simple_mvvm.viewmodel.JokeViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        JokeViewModel viewModel = new JokeViewModel();
        binding.setViewModel(viewModel);
    }
}
