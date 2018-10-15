package com.eparpalac.mvvm.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.eparpalac.mvvm.R;
import com.eparpalac.mvvm.databinding.ActivityJokeBinding;
import com.eparpalac.mvvm.viewmodel.JokeViewModel;

public class JokeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityJokeBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_joke);

        JokeViewModel viewModel = new JokeViewModel();
        binding.setViewModel(viewModel);
    }
}
