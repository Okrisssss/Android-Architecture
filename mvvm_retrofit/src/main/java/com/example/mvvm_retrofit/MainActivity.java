package com.example.mvvm_retrofit;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.mvvm_retrofit.databinding.ActivityMainBinding;
import com.example.mvvm_retrofit.presenter.Presenter;
import com.example.mvvm_retrofit.viewmodel.LoginViewModel;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding activityMainBinding;
    private LoginViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        loginViewModel = new LoginViewModel(this);
        activityMainBinding.setLoginview(loginViewModel);

        activityMainBinding.setPresenter(new Presenter() {
            @Override
            public void loginData() {
                loginViewModel.sendLoginRequest();
                showToast("Login activity");

            }
        });
    }
    void showToast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
